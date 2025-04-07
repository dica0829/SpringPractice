package services;

import model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import proxies.CommentNotificationProxy;
import repositories.CommentRepository;

public class CommentService {
    @Autowired
    private CommentNotificationProxy commentNotificationProxy;
    @Autowired
    private CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository,
                          CommentNotificationProxy commentNotificationProxy) {
        this.commentRepository = commentRepository;
        this.commentNotificationProxy = commentNotificationProxy;
    }

    public void publishComment(Comment comment) {
        commentRepository.storeComment(comment);
        commentNotificationProxy.sendComment(comment);
    }
}
