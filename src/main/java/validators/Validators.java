package validators;

import am.ik.yavi.builder.ValidatorBuilder;
import am.ik.yavi.core.Constraint;
import am.ik.yavi.core.Validator;
import dto.NestedObject;
import dto.RootObject;

public class Validators {

    public static Validator<NestedObject> nestedValidator = ValidatorBuilder.<NestedObject>of()
                                                                            .constraintOnCondition(
                                                                                      (nested, constraintGroup) -> nested.bool(),
                                                                                      c -> c.constraint(NestedObject::field, "field", Constraint::notNull))
                                                                            .failFast(true)
                                                                            .build();
    public static Validator<RootObject> rootValidator = ValidatorBuilder.<RootObject>of()
                                                                        .nest(RootObject::nested2, "nested2", nestedValidator)
                                                                        .failFast(true)
                                                                        .build();;
}
