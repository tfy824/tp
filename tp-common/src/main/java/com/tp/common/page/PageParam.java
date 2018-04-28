package com.tp.common.page;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class PageParam {

    private int pageNo = 1;//当前页

    private int pageSize = 10;//每页显示好多条

    private Map<String,String> note=new HashMap<String,String>();//搜索条件

    private Map<String,String> sort=new HashMap<String,String>();//排序条件

    /**
     * 拼接搜索条件
     * @return
     */
    public String getSortString() {
        return sort.entrySet()
                .stream()
                .filter(x -> !StringUtils.isEmpty(x.getKey())&&!StringUtils.isEmpty(x.getValue()))  //过滤掉key和value都为空的项
                .map(x -> x.getKey() + " " + x.getValue())  //map转list
                .collect(Collectors.joining(","));  //逗号拼接
    }

    public static void main(String[] args) throws JsonProcessingException {
        PageParam pageParam=new PageParam();
        pageParam.setPageNo(1);
        pageParam.setPageSize(2);
        Map<String,String> note=new HashMap<String,String>();
        note.put("note","a");
        note.put("status","1");
        Map<String,String> sort=new HashMap<String,String>();
        sort.put("loginName","");
        sort.put("name","");
        sort.put("name2","");
        ObjectMapper mapper = new ObjectMapper();
        pageParam.setNote(note);
        //pageParam.setSort(sort);
        String json =mapper.writeValueAsString(pageParam);
        System.out.println(json);

        pageParam.setSort(sort);
        String sortString = pageParam.getSortString();
        System.out.println(sortString);

        //String collect = sort.entrySet().stream().map(x -> x.getKey() + " " + x.getValue()).collect(Collectors.joining(","));
        System.out.println(pageParam.getSortString());
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public Map<String, String> getNote() {
        return note;
    }

    public void setNote(Map<String, String> note) {
        this.note = note;
    }

    public Map<String, String> getSort() {
        return sort;
    }

    public void setSort(Map<String, String> sort) {
        this.sort = sort;
    }

    /*
    public Map<String,Object> getSearch() {
        //search=123&search1=2333
        Map<String,Object> map=new HashMap<String,Object>();

        if(search!=null&&!search.equals("")){
            if(search.contains("&")){
                String[] first=search.split("&");
                for (int i = 0; i < first.length; i++) {
                    String[] sec=first[i].split("=");
                    if(sec.length==1){
                        map.put(sec[0], "");
                    }else{
                        map.put(sec[0], sec[1]);
                    }

                }
            }else{
                String[] sec=search.split("=");
                if(sec!=null){
                    if(sec.length==1){
                        map.put(sec[0], "");
                    }else{
                        map.put(sec[0], sec[1]);
                    }

                }
            }
        }
        return map;
    }

    public void setSearch(String search) {
        this.search = search;
    }*/



}
