# test

step 1: Download and import project as gradle project.

step 2: Create database "edubooks" in mysql.(database configuration is available in "application.properties" file.) 

step 3: Run TestApplication class (available in com.edubooks.test), it will start application server.

step 4: Go to localhost:8080/swagger-ui.html in browser.

step 5: Click on try it available under BookController (/user/getBooks)

this api call will fetch ISBN numbers from database nd call amazon product advertising api to lookup item.


Algorithm :

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
        
        
In above code we fetch list of ISBN numbers from repository, after that we call amazon product advertising api using DocumentBuilder,
URL is created using SignedRequestsHelper.

        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document doc = builder.parse(url);
        
        
Response will be recieved in document, after that we unmarsh document into Entity class using Unmarshaller.
details of book  with same isbn is available in New instance in Entity calss (used to save into database).
