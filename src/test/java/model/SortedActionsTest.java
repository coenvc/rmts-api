package model;

import model.action.Action;
import model.action.ActionBuilder;
import model.action.ActionType;
import model.action.SortedActions;
import model.address.AddressBuilder;
import model.profession.ProfessionBuilder;
import model.prospect.Prospect;
import model.prospect.ProspectBuilder;
import model.socialLinks.SocialLinksBuilder;
import model.status.StatusCode;
import model.status.StatusFactory;
import model.user.User;
import model.user.UserBuilder;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class SortedActionsTest {

    @Test
    public void test() throws ParseException {

        List<Action> lijstje = new ArrayList<Action>();

        User user = new UserBuilder()
                .username("hbollen")
                .password("12345test")
                .name("Henk Bollen")
                .active(true)
                .build();

        Prospect prospect = new ProspectBuilder()
                .firstName("Theo")
                .infix("van den")
                .surName("Estpersoon")
                .address(new AddressBuilder()
                        .street("Enschotsestraat")
                        .houseNumber("111")
                        .zipcode("5014DD")
                        .city("Tilburg")
                        .build())
                .profession(new ProfessionBuilder()
                        .name("CEO")
                        .build())
                .phoneNumber("0612341234")
                .emailAddress("T.Estpersoon@Test.nl")
                .imageUrl("img/user.png")
                .description("Potentieel lid")
                .socialLinks(new SocialLinksBuilder()
                        .facebook("facebook.com/user123")
                        .linkedin("linkedin.com/user123")
                        .twitter("twitter.com/user123")
                        .build())
                .status(new StatusFactory()
                        .build(StatusCode.ACTIVE))
                .build();

        lijstje.add(new ActionBuilder()
                .date(new Date())
                .actionType(new ActionType("hallo"))
                .description("sdjif")
                .isComplete(false)
                .prospect(prospect)
                .user(user)
                .build());

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.getDefault());

        lijstje.add(new ActionBuilder()
                .date(sdf.parse("25/04/2017 12:00:00"))
                .actionType(new ActionType("hallo"))
                .description("sdjif")
                .isComplete(false)
                .prospect(prospect)
                .user(user)
                .build());

        lijstje.add(new ActionBuilder()
                .date(sdf.parse("01/05/2017 17:00:00"))
                .actionType(new ActionType("hallo"))
                .description("sdjif")
                .isComplete(false)
                .prospect(prospect)
                .user(user)
                .build());

        lijstje.add(new ActionBuilder()
                .date(sdf.parse("25/06/2017 12:00:00"))
                .actionType(new ActionType("hallo"))
                .description("sdjif")
                .isComplete(false)
                .prospect(prospect)
                .user(user)
                .build());

        SortedActions sortedActions = SortedActions.filterList(lijstje);

    }

}