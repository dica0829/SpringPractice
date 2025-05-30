package services;

import org.springframework.stereotype.Component;
import proxies.CommentNotificationProxy;
import repositories.CommentRepository;
import model.Comment;

@Component
public class CommentService {
    private final CommentNotificationProxy commentNotificationProxy;
    private final CommentRepository commentRepository;

    public CommentService(
            CommentRepository commentRepository,
            CommentNotificationProxy commentNotificationProxy) {
        this.commentRepository = commentRepository;
        this.commentNotificationProxy = commentNotificationProxy;
    }

    public void publishComment(Comment comment) {
        commentRepository.storeComment(comment);
        commentNotificationProxy.sendComment(comment);
    }
}
