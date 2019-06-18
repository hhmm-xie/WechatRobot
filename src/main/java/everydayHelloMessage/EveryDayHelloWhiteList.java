package everydayHelloMessage;

import config.GlobalConfig;
import io.github.biezhi.wechat.utils.StringUtils;
import lombok.Getter;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Javior
 * @date 2019/6/18 12:42
 */
public class EveryDayHelloWhiteList {

    private static volatile EveryDayHelloWhiteList INSTANCE;

    private EveryDayHelloWhiteList(){
        group = new LinkedList<>();
        group.addAll(Arrays.stream(EVERYDAY_HELLO_GROUP_WHITE_LIST.split("#")).filter(StringUtils::isNotEmpty).collect(Collectors.toList()));
        friend = new LinkedList<>();
        friend.addAll(Arrays.stream(EVERYDAY_HELLO_FRIEND_WHITE_LIST.split("#")).filter(StringUtils::isNotEmpty).collect(Collectors.toList()));
    }

    public static EveryDayHelloWhiteList getInstance(){
        if (INSTANCE == null){
            synchronized (EveryDayHelloWhiteList.class){
                if (INSTANCE == null){
                    INSTANCE = new EveryDayHelloWhiteList();
                }
            }
        }
        return INSTANCE;
    }

    private static final String EVERYDAY_HELLO_GROUP_WHITE_LIST = GlobalConfig.getValue("everydayHello.group.whitelist","");

    private static final String EVERYDAY_HELLO_FRIEND_WHITE_LIST = GlobalConfig.getValue("everydayHello.friend.whitelist","");

    @Getter
    private List<String> group;

    @Getter
    private List<String> friend;

}
