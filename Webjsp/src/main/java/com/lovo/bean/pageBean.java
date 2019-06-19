package com.lovo.bean;

public class pageBean {
    //当前页面
    private int curentPage=1;
    //总页面
    private int maxPage;
    //一页限定行数
    private int countPage = 5;
    //总行
    private int allCount = 0;
    //起始位置
    private int startPage;

    //计算总页面
    public void maxPageF() {
        if(allCount%countPage == 0){
            maxPage = allCount/countPage;
        }else{
            maxPage = allCount/countPage+1;
        }
    }

    public int getCurentPage() {
        return curentPage;
    }

    public void setCurentPage(int curentPage) {
        this.curentPage = curentPage;
    }

    public int getMaxPage() {
        maxPageF();
        return maxPage;
    }


    public int getCountPage() {
        return countPage;
    }

    public void setCountPage(int countPage) {
        this.countPage = countPage;
    }

    public int getAllCount() {
        return allCount;
    }

    public void setAllCount(int allCount) {
        this.allCount = allCount;
    }

    public int getStartPage() {
        startPage = (curentPage-1)*countPage;
        return startPage;
    }

}
