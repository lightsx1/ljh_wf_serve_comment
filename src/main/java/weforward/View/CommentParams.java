package weforward.View;

import cn.weforward.protocol.doc.annotation.DocAttribute;
import cn.weforward.protocol.doc.annotation.DocObject;

import java.util.Date;

/**
 * @Author 1
 * @create 2020/10/23 15:36
 */

@DocObject(description = "评论创建参数")
public class CommentParams {

    protected String targetId;

    protected String description;


    @DocAttribute(necessary = true, description = "评论目标Id", example = "")
    public String getTargetId() {
        return targetId;
    }

    public void setTargetId(String targetId) {
        this.targetId = targetId;
    }


    @DocAttribute(necessary = true, description = "评论详情", example = "")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
