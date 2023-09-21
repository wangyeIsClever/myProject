package com.wangye.dubboapi.api;

import com.alibaba.fastjson2.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {

    public static void main(String[] args) {
       List<Dept> deptList = new ArrayList<>();
       deptList.add(new Dept(1L, "常家宁卖於公司", 0L, true));
       deptList.add(new Dept(2L, "卖鱼销售部", 1L, true));
       deptList.add(new Dept(3L, "技术部", 1L, true));
       deptList.add(new Dept(4L, "美女公关部", 1L, true));
       deptList.add(new Dept(5L, "咸鱼小组", 2L, false));
       deptList.add(new Dept(6L, "PUA技术小组", 3L, false));
       deptList.add(new Dept(7L, "女神公关小组", 4L, false));
       deptList.add(new Dept(8L, "情趣公关小组", 4L, false));
       deptList.add(new Dept(9L, "撩汉技术组", 3L, false));
       deptList.add(new Dept(10L, "八爪鱼销售组", 2L, false));

        Map<Long,List<Dept>> parentIdToDeptMap = new HashMap<>();
        for (Dept dept : deptList) {
            if (!parentIdToDeptMap.containsKey(dept.getParentId())) {
                parentIdToDeptMap.put(dept.getParentId(), new ArrayList<>());
            }
            List<Dept> subDeptList = parentIdToDeptMap.get(dept.getParentId());
            subDeptList.add(dept);
        }
        System.err.println(JSONObject.toJSONString(parentIdToDeptMap));

        Dept treeDept = getTreeDept(deptList, parentIdToDeptMap);

        System.err.println();
        System.err.println(JSONObject.toJSONString(treeDept));
    }

    private static Dept getTreeDept(List<Dept> deptList, Map<Long, List<Dept>> parentIdToDeptMap) {
        Dept top = null;
        // find top dept
        for (Dept dept : deptList) {
            if (dept.getParentId() == 0L) {
                top = dept;
                break;
            }
        }
        if (top == null) {
            return null;
        }
        List<Dept> subDeptList = getSubList(top.getId(), parentIdToDeptMap);
        top.setSubDeptList(subDeptList);
        return top;
    }

    private static List<Dept> getSubList(Long parentId, Map<Long, List<Dept>> parentIdToDeptMap) {
        if (parentIdToDeptMap.containsKey(parentId)) {
            List<Dept> subList = parentIdToDeptMap.get(parentId);
            for (Dept dept : subList) {
                if (dept.getHasSub()){
                    List<Dept> subList1 = getSubList(dept.getId(), parentIdToDeptMap);
                    dept.setSubDeptList(subList1);
                }
            }
            return subList;
        } else {
            return null;
        }

    }
}
