package com.arthur.bloomfilter;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

public class GuavaBloom {
    public static void main(String[] args) {
        // 创建布隆过滤器对象
//        最多 1500个整数的布隆过滤器，并且我们可以容忍误判的概率为百分之（0.01）
        BloomFilter<Integer> filter = BloomFilter.create(
                Funnels.integerFunnel(),
                1500,
                0.01);
        // 判断指定元素是否存在
        System.out.println(filter.mightContain(1));
        System.out.println(filter.mightContain(2));
        // 将元素添加进布隆过滤器
        filter.put(1);
        filter.put(2);
        System.out.println(filter.mightContain(1));
        System.out.println(filter.mightContain(2));

//        当mightContain（） 方法返回true时，我们可以99％确定该元素在过滤器中，当过滤器返回false时，我们可以100％确定该元素不存在于过滤器中。
//
//        Guava 提供的布隆过滤器的实现还是很不错的（想要详细了解的可以看一下它的源码实现），但是它有一个重大的缺陷就是只能单机使用（另外，容量
//        扩展也不容易），而现在互联网一般都是分布式的场景。为了解决这个问题，我们就需要用到 Redis 中的布隆过滤器了。

    }
}
