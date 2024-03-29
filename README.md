# legalzoom


to run,  use the maven command spring-boot:run

The services are under localhost:8083.

The project is designed as a RESTful application. There are 3 rest endpoints:

-	addcard : POST endpoint, expects a json input of the type :

{
“name”:”name”, 
“cardnumber”:”4242424242424242”, 
“expirationdate”:”MMM-yyyy”
}

Enables the insertion of an entry in the session scoped repository.

-	addcards: POST endpoint, expects a CSV file. It’s objective was to enable the insertion of a list  entries in the session scoped repository. However , currently that’s not the case. 

-	getcards : GET endpoint, returns the entries inserted from the user during his session. The result is sent back as a json list (ordered in descending date order) of elements of the type:

{
“name”:”name”, 
“censoredcardnumber”:”************4242”, 
“expirationdate”:”MMM-yyyy”
}


The root url (http://localhost:8083) points to a simple index page with a form with no current functionality.

## What is missing:


*A front-end interface*

The plan was to:

-   Implement the requests for single entry and csv insertions.
-   Implement a validation control for single entry insertion, using bootstrap.
-   On positive response from the insertion services, fetch the entries by implementing the third endpoint(getcards)

*CSV to java object conversion*

I had no prior experience in the development of endpoints accepting CSV files, and it was my major time sink. I decided to use openCSV, and had 2 options: 

-   either make a controller that directly managed the HttpServletRequest  object, extract the csv data and convert it to a list;
-   Make use of an HttpMessageConverter implementation I found, so that the conversion process could be transparent to the controller.

I decided for the second approach, finding it a more clean and simple solution. However, going forward I wasn’t able to complete a POST request with a CSV payload, due to error 415 (unsupported data type), and I wasn’t able to discover the reason.

In hindsight:

-   Had I used the first method, I could have learned more about how openCSV works and executes the conversion. 
-   Going with the second method, I had to work with another argument I wasn’t very informed on, that is, HttpMessageConverter. This represented another time sink. also, introducing a block of logic i didn't understand very well made me fail in discovering the cause of the 415 error.

*Back-end validation*

At a certain level is present. When a card object field is set, it is also validated. Null or empty fields are not permitted and result in an exception. The card number and the censored version have to pass a regex test. The date is automatically validated by spring.  That said, with more time I would have handled exceptions differently, linking the exception to a response code and a proper json response, using @ControllerAdvice.


As i wrote above, CSV handling was a big time sink. That said, in hindsight I think I should have focused more on completing the full stack experience, at least regarding single entry insertion.
