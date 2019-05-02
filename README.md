# legalzoom

The project is designed as a RESTful application. There are 3 rest endpoints:

-	addcard : POST endpoint, expects a json input of the type 
{
“name”:”name”, 
“cardnumber”:”4242424242424242”, 
“expirationdate”:”MMM-yyyy”
}
Enables the insertion of an entry in the session scoped repository
-	addcards: POST endpoint, expects a CSV file. It’s objective was to enable the insertion of a list  entries in the session scoped repository. However , currently that’s not the case. 

-	getcards : GET endpoint, returns the entries inserted from the user during his session. The result is sent back as a json list (ordered in descending date order) of elements of the type:
{
“name”:”name”, 
“censoredcardnumber”:”************4242”, 
“expirationdate”:”MMM-yyyy”
}


The root url (http://localhost:8080) points to a simple index page with a form with no current functionality.

This was done in the span of mostly a day. What is missing:

-	A front-end interface. The plan was to
o	Implement the requests for single entry and csv insertions.
o	Implement a validation control for single entry insertion, using bootstrap.
o	On positive response from the insertion services, fetch the entries by implementing the third endpoing(getcards)


-	CSV to java object conversion. I had no prior experience in the development of endpoints accepting CSV files, and it was my major time sink. I decided to use openCSV, and had 2 options: 
  o	either make a controller that directly managed the HttpServletRequest  object, extract the csv data and convert it to a list;
  o	Make use of an HttpMessageConverter implementation I found, so that the conversion process could be transparent to the controller.
I decided for the second approach, finding it a more clean and simple solution. However, going forward I wasn’t able to complete a POST request with a CSV payload, due to error 415 (unsupported data type), and I wasn’t able to discover the reason.


In hindsight:
  o	I was introducing logic I didn’t understand very well, and that for time reasons I decided to not study further;
  o	Had I used the first method, I could have learned more about how openCSV works and executes the conversion. Also, the chance of a 415   error would habe been smaller.
  o	Going with the second method, I had to work with another argument I wasn’t very informed on, that is HttpMessageConverter. This represented another time sink.


-	Back-end validation. At a certain level is present. When a card object field is set, it is also validated. Null or empty fields are not permitted and result in an exception. The card number and the censored version have to pass a regex test. The date is automatically validated by spring.  That said, with more time I would have handled better the exception system, linking the exception to a response code and a proper json response, probably using @ControllerAdvice.



As wrote above, CSV handling was a big time sink. That said, in hindsight I think I should have focused more on completing the full stack experience, at least regarding single entry insertion.
