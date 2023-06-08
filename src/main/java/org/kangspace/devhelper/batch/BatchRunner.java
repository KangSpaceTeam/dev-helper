package org.kangspace.devhelper.batch;

import java.util.List;
import java.util.function.Consumer;

/**
 * 批量执行
 *
 * @author kango2gler@gmail.com
 * @since 2023/6/8
 */
public class BatchRunner {

    /**
     * 批量处理
     *
     * @param data        需要处理的数据
     * @param batchHandle 每批次需要处理的数据
     * @param batchCount  每批次数据大小
     */
    public static <T> void batch(List<T> data, Consumer<List<T>> batchHandle, int batchCount) {
        int refLen = data.size(), len = refLen;
        for (int i = 0, nexti = (len > batchCount ? batchCount : len);
             len > 0;
             i += (i + batchCount > refLen ? refLen - i : batchCount),
                     nexti += (nexti + batchCount > refLen ? refLen - nexti : batchCount), len -= batchCount) {
            batchHandle.accept(data.subList(i, nexti));
        }
    }
}
