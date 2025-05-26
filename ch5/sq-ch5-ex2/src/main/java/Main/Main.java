package Main;

import Configuration.ProjectConfiguration;
import Services.CommentService;
import Services.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var c = new AnnotationConfigApplicationContext(ProjectConfiguration.class);

        var s1 = c.getBean(CommentService.class);
        var s2 = c.getBean(UserService.class);

        boolean b = s1.getCommentRepository() == s2.getCommentRepository();

        System.out.println(b);
        System.out.println("version4를 의미한다.");
        System.out.println("maven에 명시를 제대로 안하니까 오류가 난다.");
    }
}

//당연히 spring context에는 CommentRepository Bean이 한개밖에 없기때문에
//다른 클래스에서 참조해도 true값이 나온다.