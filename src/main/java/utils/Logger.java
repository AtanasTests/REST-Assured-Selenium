package utils;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Logger {


    public static void testStart() {
        log.info("APITestStart");
    }

    public static void testEnd() {
        log.info("APITestEnd");
    }


    public static void generalLog(String text) {
        log.info(text);
    }
    public static void TestStart(){
        log.info("--------------- Test Start --------------- ");
    }

    public static void TestEnd() {
        log.info("--------------- Test End --------------- ");
    }

    //Action Logger
    public static void GeneralLog(String input){
        log.info(input);
    }
}
