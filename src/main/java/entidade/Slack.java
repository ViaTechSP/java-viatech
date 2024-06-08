package entidade;

public class Slack {
    private Integer idBot;
    private String token;

    public Slack(Integer idBot, String token) {
        this.idBot = idBot;
        this.token = token;
    }

    public Slack() {
    }

    public Integer getIdBot() {
        return idBot;
    }

    public void setIdBot(Integer idBot) {
        this.idBot = idBot;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "Slack{" +
                "idBot=" + idBot +
                ", token='" + token + '\'' +
                '}';
    }
}
