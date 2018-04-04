package es.voghdev.prjdagger2.ui.presenter;

import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import es.voghdev.prjdagger2.global.ResLocator;


public class DetailPresenterTest {

    @Mock
    ResLocator mockResLocator;

    @Mock
    DetailPresenter.MVPView mockView;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    private DetailPresenter createMockedPresenter() {
        DetailPresenter presenter = new DetailPresenter(mockResLocator);
        presenter.setView(mockView);
        return presenter;
    }
}
