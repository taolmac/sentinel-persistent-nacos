package com.taos.extension.sentinelrulepush.common;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.taos.extension.sentinelrulepush.utils.R;

/**
 * 降级处理类
 */
public class ExceptionUtil {

    public static R fallback(Integer id, Throwable e){
        return R.error(-2,"=========被异常降级啦===");
    }

    public static R handleException(Integer id, BlockException e){
        return R.error(-1,"==========被限流啦===");
    }
}
