package weforward;

import cn.weforward.common.ResultPage;

/**
 * @Author 1
 * @create 2020/10/23 15:51
 */
public interface CommentService {

    Comment createComment(String targetId, String description);

    ResultPage<Comment> getAllCommentsByTargetId(String targetId);

}
