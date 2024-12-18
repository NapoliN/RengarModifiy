package rengar.parser.ast;

import com.alibaba.fastjson.JSONObject;

// (?<=X)
public class LookbehindExpr extends LookaroundExpr {
    public LookbehindExpr(RegexExpr cond, boolean isNot) {
        super(cond, isNot);
    }

    @Override
    public JSONObject genJsonExpression(){
        JSONObject json = new JSONObject();
        json.put("id", getExprId());
        json.put("type", "Lookbehind");
        json.put("body", cond.genJsonExpression());
        json.put("isNot", isNot);
        return json;
    }

    @Override
    public String genString() {
        StringBuilder sb = new StringBuilder();
        sb.append("(?<");
        if (isNot)
            sb.append('!');
        else
            sb.append('=');
        sb.append(cond.genString());
        sb.append(')');
        return sb.toString();
    }

    @Override
    public LookbehindExpr copy() {
        LookbehindExpr newLookbehindExpr = new LookbehindExpr(cond.copy(), isNot);
        newLookbehindExpr.setExprId(getExprId());
        return newLookbehindExpr;
    }
}