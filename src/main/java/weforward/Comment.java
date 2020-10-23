package weforward;


import cn.weforward.data.UniteId;

import java.util.Date;

public interface Comment {

    UniteId getId();

    String getTargetId();

    String getCreator();

    String getDescription();

    Date getCreateTime();

}
