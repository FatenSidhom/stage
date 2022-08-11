package com.wevioo.generator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Model {

    // Template file name
    String templateName;

    // List of key/value attributes to be replaced in the template
    List<Attribute> attributeList; 

    // Document type: docx, doc, pdf 
    String type;
}

