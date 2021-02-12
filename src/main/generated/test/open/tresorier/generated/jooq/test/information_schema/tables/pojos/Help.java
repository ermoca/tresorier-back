/*
 * This file is generated by jOOQ.
 */
package open.tresorier.generated.jooq.test.information_schema.tables.pojos;


import java.io.Serializable;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Help implements Serializable {

    private static final long serialVersionUID = 502343099;

    private final Integer id;
    private final String  section;
    private final String  topic;
    private final String  syntax;
    private final String  text;

    public Help(Help value) {
        this.id = value.id;
        this.section = value.section;
        this.topic = value.topic;
        this.syntax = value.syntax;
        this.text = value.text;
    }

    public Help(
        Integer id,
        String  section,
        String  topic,
        String  syntax,
        String  text
    ) {
        this.id = id;
        this.section = section;
        this.topic = topic;
        this.syntax = syntax;
        this.text = text;
    }

    public Integer getId() {
        return this.id;
    }

    public String getSection() {
        return this.section;
    }

    public String getTopic() {
        return this.topic;
    }

    public String getSyntax() {
        return this.syntax;
    }

    public String getText() {
        return this.text;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Help (");

        sb.append(id);
        sb.append(", ").append(section);
        sb.append(", ").append(topic);
        sb.append(", ").append(syntax);
        sb.append(", ").append(text);

        sb.append(")");
        return sb.toString();
    }
}
