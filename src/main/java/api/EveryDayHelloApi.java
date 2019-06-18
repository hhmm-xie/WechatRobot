package api;

import config.GlobalConfig;
import io.github.biezhi.wechat.utils.StringUtils;
import robot.Ciba.CibaEveryDayHello;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Javior
 * @date 2019/6/18 12:27
 */
public class EveryDayHelloApi {

    private static final String EVERYDAY_HELLO = GlobalConfig.getValue("everydayHelloApi", "");

    private static final String DEFAULT_EVERYDAY_HELLO = GlobalConfig.getValue("everydayHello.default", "");

    public static String getEverydayHello() {
        String msg = getMsg();
        return StringUtils.isEmpty(msg) ? DEFAULT_EVERYDAY_HELLO : msg;
    }

    private static String getMsg() {
        switch (EVERYDAY_HELLO) {
            case "Ciba":
                return CibaEveryDayHello.getCibaEveryday();
            default:
                return null;
        }
    }

}
