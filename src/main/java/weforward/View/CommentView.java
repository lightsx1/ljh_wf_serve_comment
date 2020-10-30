package weforward.View;

import cn.weforward.protocol.doc.annotation.DocAttribute;
import cn.weforward.protocol.doc.annotation.DocObject;
import weforward.Comment;

import java.awt.image.DataBufferShort;
import java.util.Date;

/**
 * @Author 1
 * @create 2020/10/23 15:34
 */

@DocObject(description = "评论视图视图")
public class CommentView {

    protected Comment comment;

    public CommentView(Comment comment) {
        this.comment  = comment;
    }

    public static CommentView valueOf(Comment comment) {
        return null == comment ? null : new CommentView(comment);
    }

    @DocAttribute(description = "评论id")
    public String getId() {
        return comment.getId().getOrdinal();
    }

    @DocAttribute(description = "评论创建人")
    public String getCreator() {
        return comment.getCreator();
    }

    @DocAttribute(description = "评论创建时间")
    public Date getCreateTime() {
        return comment.getCreateTime();
    }

    @DocAttribute(description = "评论详情")
    public String getDescription() {
        return comment.getDescription();
    }

    @DocAttribute(description = "评论目标id")
    public String getTargetId() {
        return comment.getTargetId();
    }

}
