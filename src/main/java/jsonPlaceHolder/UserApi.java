package jsonPlaceHolder;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class UserApi {

//    TODO
//    1. Call api
//    2. send the request
//    3. Get the response with status code
//    4. Validate the status code

    static String urlName = "https://jsonplaceholder.typicode.com/users/";
    static Response result = given().when().get(urlName);

    public static void main(String[] args) {
        getAllUsers(); //print all 10 users
        getStatusCode(); //print the status code
        getUserByID(); // print the user by id
    }

    public static void getAllUsers() {
        result.thenReturn()
                .body()
                .prettyPrint();
    }

    public static void getStatusCode() {
        result.then().assertThat().statusCode(200).log().status();
    }

    //    print the user 2,4,6,8, and 9.... code ..??
    public static void getUserByID() {
        int[] ids = {2, 4, 6, 8, 9};
        for (int id : ids) {
            given().when().get(urlName + id)
                    .thenReturn().prettyPrint();
        }
    }


}
