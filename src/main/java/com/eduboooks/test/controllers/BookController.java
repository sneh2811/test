package com.eduboooks.test.controllers;

import com.eduboooks.test.controllers.util.SignedRequestsHelper;
import com.eduboooks.test.domain.Book;
import com.eduboooks.test.domain.ISBN;
import com.eduboooks.test.repositories.BookRepository;
import com.eduboooks.test.repositories.ISBNRepository;
import io.swagger.annotations.ApiParam;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/user")
public class BookController {


    private static final String ACCESS_KEY_ID = "AKIAIIMBBIYFE5RLM7GQ";
    private static final String SECRET_KEY = "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";
    private static final String ENDPOINT = "webservices.amazon.com";
    private final ISBNRepository isbnRepository;
    private final BookRepository bookRepository;
    SignedRequestsHelper helper;

    public BookController(ISBNRepository isbnRepository, BookRepository bookRepository) {
        this.isbnRepository = isbnRepository;
        this.bookRepository = bookRepository;
    }

    private static Document getResponse(String url) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document doc = builder.parse(url);
        return doc;
    }

    private static void printResponse(Document doc) throws TransformerException, FileNotFoundException, TransformerException {
        Transformer trans = TransformerFactory.newInstance().newTransformer();
        Properties props = new Properties();
        props.put(OutputKeys.INDENT, "yes");
        trans.setOutputProperties(props);
        StreamResult res = new StreamResult(new StringWriter());
        DOMSource src = new DOMSource(doc);
        trans.transform(src, res);
        String toString = res.getWriter().toString();
        System.out.println(toString);
    }

    @GetMapping("/getBooks")
    public void getBooks(@ApiParam Pageable pageable) {
        try {
            helper = SignedRequestsHelper.getInstance(ENDPOINT, ACCESS_KEY_ID, SECRET_KEY);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        String requestUrl = null;

        Map<String, String> params = new HashMap<String, String>();

        params.put("Service", "AWSECommerceService");
        params.put("Operation", "ItemLookup");
        params.put("AWSAccessKeyId", "AKIAIIMBBIYFE5RLM7GQ");
        params.put("AssociateTag", "barrycasale-20");
        params.put("IdType", "ISBN");
        params.put("ResponseGroup", "Large");
        params.put("SearchIndex", "Books");


        List<ISBN> isbnList = isbnRepository.findAll();
        for (int i = 0; i < isbnList.size(); i++) {
            requestUrl = helper.sign(params);
            params.put("ItemId", "9780226774466");

            try {
                Document response = getResponse(requestUrl);
                JAXBContext jc = JAXBContext.newInstance(ISBN.class);
                Unmarshaller unmarshaller = jc.createUnmarshaller();
                Book book = (Book) unmarshaller.unmarshal(response);
                if(isbnList.get(i).getIsbn().equals(book.getIsbn())) {
                    bookRepository.save(book);
                }
                printResponse(response);
            } catch (Exception ex) {
                Logger.getLogger(BookController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}