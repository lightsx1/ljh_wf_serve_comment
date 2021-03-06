package weforward.Impl;

import cn.weforward.common.ResultPage;
import cn.weforward.common.util.ResultPageHelper;
import cn.weforward.data.persister.PersisterFactory;
import cn.weforward.data.persister.ext.ConditionUtil;
import cn.weforward.data.persister.ext.OrderByUtil;
import cn.weforward.framework.WeforwardSession;
import cn.weforward.framework.support.Global;
import cn.weforward.protocol.ops.User;
import weforward.Comment;
import weforward.CommentService;

import java.util.ArrayList;
import java.util.List;

/**
 * @create 2020/10/23 15:51
 */
public class CommentServiceImpl extends CommentDiImpl implements CommentService {

    private String getUser() {
        User user = WeforwardSession.TLS.getOperator();
        String name = null == user ? "admin" : user.getName();
        return name;
    }

    public CommentServiceImpl(PersisterFactory factory) {
        super(factory);
    }

    @Override
    public Comment createComment(String targetId, String description) {
        return new CommentImpl(this, targetId, getUser(), description);
    }

    @Override
    public ResultPage<Comment> getAllCommentsByTargetId(String targetId) {
        ResultPage<? extends Comment> rp = commentPersister.search(
                ConditionUtil.eq(ConditionUtil.field("targetId"), targetId), OrderByUtil.desc("createTime")
        );

        List<Comment> list = new ArrayList<>();
        for (Comment comment : ResultPageHelper.toForeach(rp)) {
            list.add(comment);
        }
        return ResultPageHelper.toResultPage(list);
    }


}
