package server.server;

import com.google.gson.JsonObject;
import lombok.experimental.PackagePrivate;
import org.joda.time.DateTime;
import org.joda.time.Period;
import org.joda.time.format.PeriodFormatter;
import org.joda.time.format.PeriodFormatterBuilder;

import java.io.PrintWriter;

@PackagePrivate
class CommandsService {

    void getUptime(PrintWriter out, DateTime serverTime) {
        DateTime now = new DateTime();
        Period period = new Period(serverTime, now);
        JsonObject answer = new JsonObject();
        PeriodFormatter formatter = new PeriodFormatterBuilder()
                .appendDays().appendSuffix(" d ")
                .appendHours().appendSuffix(" h ")
                .appendMinutes().appendSuffix(" min ")
                .appendSeconds().appendSuffix(" s ")
                .printZeroNever()
                .toFormatter();

        String elapsed = formatter.print(period);
        answer.addProperty("uptime ", elapsed);
        out.println(answer);

    }

    void getServerInfo(PrintWriter out, DateTime serverStart) {
        JsonObject answer = new JsonObject();
        answer.addProperty("serverVersion", ServerConstants.SERVER_VERSION);
        answer.addProperty("createdAt ", serverStart.toString());
        out.println(answer);
    }

    void getHelp(PrintWriter out) {
        JsonObject answer = new JsonObject();
        answer.addProperty("help", "Returns the list of available commands.");
        answer.addProperty("info", "Returns the server creation date and version.");
        answer.addProperty("uptime", "Returns server uptime.");
        answer.addProperty("stop", "Bye");
        out.println(answer);
    }
}



