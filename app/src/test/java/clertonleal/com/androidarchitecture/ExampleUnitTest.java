package clertonleal.com.androidarchitecture;

import org.junit.Before;
import org.junit.Test;

import clertonleal.com.androidarchitecture.model.User;
import clertonleal.com.androidarchitecture.presenter.CreateUserPresenter;
import clertonleal.com.androidarchitecture.presenter.CreateUserView;

import static org.mockito.Mockito.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    private static final String USER_FIRST_NAME = "Clerton";
    private static final String USER_LAST_NAME = "Leal";
    private static final String EMAIL = "clertonleal@gmail.com";
    private static final String RG = "**********";
    private static final String CPF = "**********";
    private CreateUserPresenter createUserPresenter;
    private CreateUserView createUserView;

    @Before
    public void setUp() {
        createUserView = mock(CreateUserView.class);
        createUserPresenter = new CreateUserPresenter(createUserView);
    }

    @Test
    public void onCreateUserClickAndAllFieldsFilledShouldCreateUser() throws Exception {
        when(createUserView.getFirstName()).thenReturn(USER_FIRST_NAME);
        when(createUserView.getLastName()).thenReturn(USER_LAST_NAME);
        when(createUserView.getEmail()).thenReturn(EMAIL);
        when(createUserView.getRg()).thenReturn(RG);
        when(createUserView.getCpf()).thenReturn(CPF);

        createUserPresenter.validateAndCreateUser();

        User user = new User(USER_FIRST_NAME, USER_LAST_NAME, RG, CPF, EMAIL);

        verify(createUserView).createUser(eq(user));
    }

    @Test
    public void onCreateUserClickAndNameIsNotFilledShouldErrorMessage() throws Exception {
        when(createUserView.getFirstName()).thenReturn("");
        when(createUserView.getLastName()).thenReturn(USER_LAST_NAME);
        when(createUserView.getEmail()).thenReturn(EMAIL);
        when(createUserView.getRg()).thenReturn(RG);
        when(createUserView.getCpf()).thenReturn(CPF);

        createUserPresenter.validateAndCreateUser();

        verify(createUserView, never()).createUser(any(User.class));
        verify(createUserView).setFirstNameError();
    }
}