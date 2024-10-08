package rengar.parser.ast;

// (?>X)
// https://stackoverflow.com/questions/50524/what-is-a-regex-independent-non-capturing-group
public class IndependentGroupExpr extends GroupExpr {
    public IndependentGroupExpr(RegexExpr body) {
        super(body);
    }

    @Override
    public String genJsonExpression(){
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append(String.format("\"id\": %d,",getExprId()));
        sb.append("\"type\": \"Group\",");
        sb.append("\"body\": ");
        sb.append(getBody().genJsonExpression());
        sb.append("}");
        return sb.toString();
    }

    @Override
    public String genString() {
        StringBuilder sb = new StringBuilder();
        sb.append("(?>");
        sb.append(getBody().genString());
        sb.append(')');
        return sb.toString();
    }

    @Override
    public IndependentGroupExpr copy() {
        IndependentGroupExpr newIndependentGroupExpr = new IndependentGroupExpr(getBody().copy());
        newIndependentGroupExpr.setExprId(getExprId());
        return newIndependentGroupExpr;
    }
}