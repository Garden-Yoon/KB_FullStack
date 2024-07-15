import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class JUnitCycleTest {
    // 전체 테스트 시작 전 1회 실행, static 선언
    @BeforeAll
    static void beforeAll() {
        System.out.println("@BeforeAll");
    }

    // 테스트 케이스를 시작하기 전마다 실행
    @BeforeEach
    public void beforeEach() {
        System.out.println("@BeforeEach");
    }

    @Test
    public void test1(){
        System.out.println("test1");
    }

    @Test
    public void test2(){
        System.out.println("test2");
    }

    @Test
    public void test3(){
        System.out.println("test3");
    }

    // 테스트케이스를 종료하기 전마다 실행
    @AfterEach
    public void afterEach() {
        System.out.println("@AfterEach");
    }

    // 전체 테스트를 마치고 종료하기 전 1회, static 선언
    static void afterAll(){
        System.out.println("@AfterAll");
    }

}
