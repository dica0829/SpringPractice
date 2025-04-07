package main;

import Configuration.ProjectConfig;
import model.Comment;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.CommentService;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        var comment = new Comment();
        comment.setText("Demo comment");
        comment.setAuthor("Sexy Boy");

        var commentService = context.getBean(CommentService.class);
        commentService.publishComment(comment);

    }
}
