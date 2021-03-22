Retrofit2 Basics

Date: 18/02/2021.

- Retrofit2 is a REST client for Android.
- It wraps OkHttp as it's networking protocol.

- For examples google something like "Retrofit2 android tutorial".
- The guide this project is based on is found: https://www.journaldev.com/13639/retrofit-android-example-tutorial
- The above guide has mistakes but you can fix it as practice.
- https://reqres.in/ is a website where you can test public API calls to test Retrofit.
    - You can do additional practice by making use of the sample data that you can get from the API.
- Be sure to read up on OkHttp/Retrofit2 to learn the other features of the libraries.

- In practice, you can use Retrofit as a singleton (so you have a single client that is reused).
    - Better for efficiency but look out for any side-effects.
    - Can handle multiple requests but have max requests (that can be configured).
    - https://stackoverflow.com/questions/36628399/should-i-use-retrofit-with-a-singleton
    - If you use different APIs you can have a client for each? Better than 1 for every call.

- If want to use less anonymous / inline methods/classes (e.g. callbacks) you might have to pass 
context to the custom callback class so it can call methods in the separate context/java file. 

Other References:
- https://www.vogella.com/tutorials/Retrofit/article.html