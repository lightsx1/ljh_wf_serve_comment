package weforward.weforward;

import cn.weforward.common.ResultPage;
import cn.weforward.common.util.TransResultPage;
import cn.weforward.framework.ApiException;
import cn.weforward.framework.WeforwardMethod;
import cn.weforward.framework.WeforwardMethods;
import cn.weforward.framework.doc.DocMethods;
import cn.weforward.framework.util.ValidateUtil;
import cn.weforward.protocol.doc.annotation.DocAttribute;
import cn.weforward.protocol.doc.annotation.DocMethod;
import cn.weforward.protocol.doc.annotation.DocParameter;
import cn.weforward.protocol.support.datatype.FriendlyObject;
import weforward.Comment;
import weforward.CommentService;
import weforward.View.CommentParams;
import weforward.View.CommentView;

import javax.annotation.Resource;

/**
 * @Author 1
 * @create 2020/10/23 15:35
 */

@DocMethods(index = 100)
@WeforwardMethods
public class CommentMethods {

    @Resource
    protected CommentService commentService;

    @WeforwardMethod
    @DocMethod(description = "创建评论", index = 0)
    public CommentView createDemand(CommentParams params) throws ApiException {

        String targetId = params.getTargetId();
        String description = params.getDescription();

        ValidateUtil.isEmpty(targetId, "评论目标id不能为空");
        ValidateUtil.isEmpty(description, "评论详情不能为空");

        Comment comment = commentService.createComment(targetId,description);
        return CommentView.valueOf(comment);
    }

    @WeforwardMethod
    @DocMethod(description = "根据目标id查询所有评论", index = 1)
    @DocParameter(@DocAttribute(name = "targetId", type = String.class, necessary = true, description = "目标id"))
    public TransResultPage<CommentView, Comment> getAllCommentsByTargetId(FriendlyObject params) throws ApiException {

        String targetId = params.getString("targetId");

        ValidateUtil.isEmpty(targetId, "目标id不能为空");

        ResultPage<Comment> rp =commentService.getAllCommentsByTargetId(targetId);

        return new TransResultPage<CommentView, Comment>(rp) {
            @Override
            protected CommentView trans(Comment src) {
                return CommentView.valueOf(src);
            }
        };
    }

}
