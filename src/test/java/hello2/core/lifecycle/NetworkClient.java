package hello2.core.lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class NetworkClient {
    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출, url = " + url);
    }

    public void setUrl(String url){
        this.url = url;
    }

    public void connect(){
        System.out.println("connect: "+ url);
    }

    public void call(String message){
        System.out.println("call: " + url+ "message: "+ message);
    }

    public void disconnect(){
        System.out.println("close: " + url);
    }


    @PostConstruct
    public void close() throws Exception {
        System.out.println(" bean 소멸 ");
        connect();
        call("초기화 연결 메시지");
    }

    @PreDestroy
    public void init() throws Exception {
        System.out.println("의존 관계 설정 끝");
        disconnect();
    }
}
