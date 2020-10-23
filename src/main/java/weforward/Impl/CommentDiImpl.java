package weforward.Impl;

import cn.weforward.data.UniteId;
import cn.weforward.data.persister.Persistent;
import cn.weforward.data.persister.Persister;
import cn.weforward.data.persister.PersisterFactory;
import weforward.Comment;
import weforward.Di.CommentDi;

/**
 * @Author 1
 * @create 2020/10/23 15:28
 */
public class CommentDiImpl implements CommentDi {

    protected PersisterFactory Factory;

    protected Persister<CommentImpl> commentPersister;

    public CommentDiImpl(PersisterFactory factory) {
        Factory = factory;
        this.commentPersister = factory.createPersister(CommentImpl.class,this);
    }

    @Override
    public Comment getComment(UniteId id) {
        return commentPersister.get(id);
    }

    @Override
    public <E extends Persistent> Persister<E> getPersister(Class<E> clazz) {
        return Factory.getPersister(clazz);
    }
}
