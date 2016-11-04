package clertonleal.com.androidarchitecture;

import org.junit.Before;
import org.junit.Test;

import clertonleal.com.androidarchitecture.model.User;
import clertonleal.com.androidarchitecture.ui.viewInterface.CreateUserView;
import clertonleal.com.androidarchitecture.viewModel.CreateUserViewModel;

import static org.junit.Assert.*;
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
    public static final String MANDATORY_FIELD = "Mandatory field";

    private CreateUserViewModel createViewModel;
    private CreateUserView createUserView;

    @Before
    public void setUp() {
        createUserView = mock(CreateUserView.class);
        when(createUserView.getString(eq(R.string.mandatory_field))).thenReturn(MANDATORY_FIELD);
        createViewModel = new CreateUserViewModel(createUserView);
    }

    @Test
    public void onCreateUserClickAndAllFieldsFilledShouldCreateUser() throws Exception {
        User user = new User(USER_FIRST_NAME, USER_LAST_NAME, RG, CPF, EMAIL);
        createViewModel.onCreateUser(user);
        verify(createUserView).onUserCreated(eq(user));
    }

    @Test
    public void onCreateUserClickAndNameIsNotFilledShouldErrorMessage() throws Exception {
        User user = new User("", USER_LAST_NAME, RG, CPF, EMAIL);
        createViewModel.onCreateUser(user);

        verify(createUserView, never()).onUserCreated(any(User.class));
        assertEquals(MANDATORY_FIELD, createViewModel.firstNameError.get());
    }
}