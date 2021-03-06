package control;

import entity.articles.*;
import entity.users.CorporateUser;
import entity.users.PrivateUser;
import entity.users.RegisteredUser;
import exceptions.ErrorInBalanceException;
import exceptions.FailedPaymentException;

import java.sql.*;
import java.util.ArrayList;


public class DaDaSystem{

    private static DaDaSystem ourInstance = new DaDaSystem();

    public static DaDaSystem getInstance() {
        return ourInstance;
    }

    private DaDaSystem() {
    }

    public RegisteredUser findByPrimaryKey(String userID)
    {

        RegisteredUser user = null;
        try {
            user = DatabaseController.getInstance().findByPrimaryKey(userID);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return user;
    }

    public PrivateUser findPrivateUser(String email)
    {
        PrivateUser user = null;
        try {
            user = PrivateDBcontroller.getOurInstance().findUser(email);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    public CorporateUser findCorporateUser(String email)
    {
        CorporateUser user = null;
        try {
            user = CorporateDBcontroller.getOurInstance().findUser(email);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    public PrivateUser saveDataPrivate(String name, String email, String surname, String pwd, int type)
    {
        PrivateUser user;
        user = UserFactory.getInstance().createUser();

        user.setName(name);
        user.setSurname(surname);
        user.setEmail(email);
        user.setPwd(pwd);
        user.setType(type);

        return user;
    }

    public boolean checkUserPriv(String mail) throws Exception
    {
        return DatabaseController.getInstance().checkUser(mail);
    }

    public void addUserPriv(PrivateUser newUser) throws Exception
    {
        PrivateDBcontroller.getOurInstance().addUser(newUser);
    }

    public void addArticle(Article article) throws Exception
    {
        DatabaseController.getInstance().addArticle(article);
    }

    public void addBook(Book book) throws Exception{
        DatabaseController.getInstance().addBook(book);
    }


    public void addElectronics(Electronics electronics) throws Exception{
        DatabaseController.getInstance().addElectronics(electronics);
    }


    public void addClothing(Clothing clothing) throws Exception{
        DatabaseController.getInstance().addClothing(clothing);
    }


    public void addTextBook(TextBook textBook) throws Exception{
        DatabaseController.getInstance().addTextBook(textBook);
    }


    public boolean checkArticle(String name, String mail) throws Exception{
        return DatabaseController.getInstance().checkArticle(name, mail);
    }


    public String getImageName(String name, String owner) throws Exception{
        return DatabaseController.getInstance().getImageName(name, owner);
    }

    ArrayList<String> getArticles(String sql) throws SQLException, ClassNotFoundException
    {
        return DatabaseController.getInstance().getArticles(sql);
    }

    public void addUserCorp(CorporateUser newUser) throws Exception{
        CorporateDBcontroller.getOurInstance().addUser(newUser);
    }

    public boolean checkUser(String mail) throws Exception{
        return DatabaseController.getInstance().checkUser(mail);
    }

    public int setWarningUser(String testo, String proprietario, String utente) throws ClassNotFoundException{
        return DatabaseController.getInstance().setWarningUser(testo, proprietario, utente);
    }

    public ArrayList<Article> searchArticle(String sql, String kind) throws SQLException{
        return DatabaseController.getInstance().searchArticle(sql, kind);
    }

    public boolean addMoney(String email, float money) throws Exception{
        if (DatabaseController.getInstance().addMoney(email, money))
                return true;
        else
            throw new ErrorInBalanceException();
    }

    public ArrayList<Article> listAllArticles() throws Exception {
        return DatabaseController.getInstance().listAllArticles();
    }

    public void buyArticle(String acquirente, String proprietario, String nomeArticolo, float saldo, float prezzo, int quantitaBuy, int quantitatot)
    {
        Thread transaction = new PaymentController(prezzo, saldo, quantitaBuy, quantitatot, acquirente, proprietario, nomeArticolo);

        transaction.start();

        //implementare un observer qui

    }
}
