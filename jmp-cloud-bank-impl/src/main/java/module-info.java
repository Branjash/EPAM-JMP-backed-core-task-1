module jmpcloudbankimpl {
    requires spring.context;
    requires spring.beans;
    requires spring.core;
    requires jmpbankapi;
    exports com.epam.jmp.impl;

    opens com.epam.jmp.impl to spring.core;
}