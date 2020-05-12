package com.Java核心技术;

import com.sun.nio.sctp.NotificationHandler;

import java.security.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @ClassName:
 * @Description:
 * @author:
 * @date:
 * @Version:
 * @Copyright:
 */
public abstract class WordCheckPermission extends Permission {
      private String action;
    /**
     * Constructs a permission with the specified name.
     *
     * @param target name of the Permission object being created.
     */
    public WordCheckPermission(String target,String anAction) {
        super(target);
        action = anAction;
    }

    public String getAction() {
        return action;
    }

    @Override
    public boolean equals(Object other) {
       if (other == null) return false;
       if (!getClass().equals(other.getClass())) return false;
       WordCheckPermission b = (WordCheckPermission) other;
       if (!Objects.equals(action,b.action)) return false;
       if ("insert".equals(action)) return Objects.equals(getName(),b.getName());
       else if ("avoid".equals(action)) return badWordSet().equals(b.badWordSet());
       else return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(),action);
    }

    public Set<String> badWordSet(){
        Set<String> set = new HashSet<>();
        set.addAll(Arrays.asList(getName().split(",")));
        return set;
    }

    @Override
    public boolean implies(Permission other) {
        if (!(other instanceof WordCheckPermission)) return false;
        WordCheckPermission b = (WordCheckPermission) other;
        if (action.equals("insert")){
            return b.action.equals("insert") && getName().indexOf(b.getName()) >= 0;
        }
        else if (action.equals("avoid")){
            if (b.action.equals("avoid")) return b.badWordSet().containsAll(badWordSet());
            else if (b.action.equals("insert")){
                for (String badWord:badWordSet()) {
                    if (b.getName().indexOf(badWord) >= 0) return false;
                }
                return true;
            }
            else return false;
        }
        else return false;
    }
}
