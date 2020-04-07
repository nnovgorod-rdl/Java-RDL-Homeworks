package pks.ent;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pks.ent.annotations.Child;
import pks.ent.annotations.Parent;

public class TestAnnotations {
    @Test
    @DisplayName("Full test Parent & Child")
    public void fullTestParentAndChild() {
        //Parent test
        Parent parent = new Parent();
        Assertions.assertNotNull(parent);
        Assertions.assertEquals(Parent.class, parent.getClass());
        parent.setName("Kirill");
        Assertions.assertEquals("Kirill", parent.getName());

        //Child test
        Child child = new Child();
        Assertions.assertNotNull(child);
        Assertions.assertEquals(Child.class, child.getClass());
        child.setParent(parent);
        child.setChildName("Dariya");
        child.setYearOfBirthday(2012);
        Assertions.assertAll("child",
                () -> Assertions.assertNotNull(child.getChildName()),
                () -> Assertions.assertEquals("Dariya", child.getChildName()),
                () -> Assertions.assertEquals(2012, child.getYearOfBirthday()),
                () -> Assertions.assertEquals("Kirill", child.getParent().getName()));
    }
}
