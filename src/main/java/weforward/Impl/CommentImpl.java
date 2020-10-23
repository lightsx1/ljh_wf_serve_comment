package weforward.Impl;

import cn.weforward.data.UniteId;
import cn.weforward.data.persister.support.AbstractPersistent;
import weforward.Comment;
import weforward.Di.CommentDi;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @Author 1
 * @create 2020/10/23 15:18
 */
public class CommentImpl extends  AbstractPersistent <CommentDi> implements Comment {

    @Resource
    protected String targetId;

    @Resource
    protected String creator;

    @Resource
    protected String description;

    @Resource
    protected Date createTime;

    protected CommentImpl(CommentDi di) {
        super(di);
    }

    public CommentImpl(CommentDi di, String targetId, String creator, String description) {
        super(di);
        genPersistenceId("comment");
        this.targetId = targetId;
        this.creator = creator;
        this.description = description;
        this.createTime = new Date(System.currentTimeMillis());
        markPersistenceUpdate();
    }

    @Override
    public UniteId getId() {
        return getPersistenceId();
    }

    public String getTargetId() {
        return targetId;
    }

    public String getCreator() {
        return creator;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateTime() {
        return createTime;
    }

}
