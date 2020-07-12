class Soultion {
    Double[][] memo; // 记忆数组
    public double probabilityOfHeads(double[] prob, int target) {
        // 初始化记忆数组
        memo=new Double[prob.length][target+1];
        // 递归求解
        return help(prob, target, 0);
    }
    
    // prob为概率数组
    // t为当前还剩下的target
    // index为当前下标
    double help(double[] prob, int t, int index){
        // 当t大于剩下数组长度时，表示剩下的硬币都是正面也无法满足条件
        // 当t小于0时代表正面朝上的个数已经超过target了
        // 返回0
        if(t>prob.length-index || t<0) return 0;
        // 递归结束条件
        if(index==prob.length) return 1;
        // 记忆数组若存在，直接返回
        if(memo[index][t]!=null) return memo[index][t];
        // 返回结果：
        // 当前硬币正面朝下的概率
        double res = (1-prob[index])*help(prob, t,index+1);
        // 加上当前硬币正面朝上的概率
        res+=prob[index]*help(prob, t-1,index+1);
        memo[index][t]=res; // 将结果保存至记忆数组
        return res;
    }    
}
