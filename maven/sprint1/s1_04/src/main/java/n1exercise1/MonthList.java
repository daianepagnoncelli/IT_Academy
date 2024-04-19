package n1exercise1;

import java.util.ArrayList;
import java.util.List;

public class MonthList {
    private List<String> months;

    public MonthList() {
        initializeMonths();
    }

    private void initializeMonths() {
        months = new ArrayList<>();

        months.add("gener");
        months.add("febrer");
        months.add("març");
        months.add("abril");
        months.add("maig");
        months.add("juny");
        months.add("juliol");
        months.add("agost");
        months.add("setembre");
        months.add("octubre");
        months.add("novembre");
        months.add("desembre");
    }

    public List<String> getMonths() {
        return months;
    }
}
