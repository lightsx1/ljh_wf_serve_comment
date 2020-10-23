package weforward.Di;

import cn.weforward.data.UniteId;
import cn.weforward.data.persister.BusinessDi;
import weforward.Comment;

/**
 * @Author 1
 * @create 2020/10/23 15:24
 */
public interface CommentDi extends BusinessDi {

    Comment getComment(UniteId id);

}
