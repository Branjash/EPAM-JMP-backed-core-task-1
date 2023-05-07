module jmpdto {
    requires jakarta.persistence;
    requires spring.data.commons;
    exports com.epam.jmp.dto;
    exports com.epam.jmp.jpa;
    exports com.epam.jmp.exception;
}