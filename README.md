# Hello
# Entity Relationship Table

| **Entity**        | **Attributes**                                                                                   | **Relationships**                                                                                  |
|--------------------|-------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------|
| **Guardian**       | `id (Long, PK)`, `name (String)`, `email (String)`, `mobile (String)`                           | One Guardian can have many Students.                                                             |
| **Student**        | `studentId (Long, PK)`, `firstName (String)`, `lastName (String)`, `emailId (String)`           | Many Students belong to one Guardian.<br>Many Students are enrolled in one Course.               |
| **Teacher**        | `teacherId (Long, PK)`, `firstName (String)`, `lastName (String)`                               | One Teacher can teach many Courses.                                                              |
| **Course**         | `courseId (Long, PK)`, `title (String)`, `credit (Integer)`                                     | One Course belongs to one Teacher.<br>One Course has one CourseMaterial.<br>One Course has many Students. |
| **CourseMaterial** | `courseMaterialId (Long, PK)`, `url (String)`                                                   | One CourseMaterial is linked to one Course.                                                      |

# Entity Relationships


# Entity Relationship Design

### Guardian
| **Attribute** | **Type**  |
|---------------|-----------|
| name          | String    |
| email         | String    |
| mobile        | String    |

---

### Student
| **Attribute** | **Type**  |
|---------------|-----------|
| studentId     | Long      |
| firstName     | String    |
| lastName      | String    |
| emailId       | String    |
| guardian      | Guardian  |
| course        | Course    |

---

### Teacher
| **Attribute** | **Type**  |
|---------------|-----------|
| teacherId     | Long      |
| firstName     | String    |
| lastName      | String    |

---

### Course
| **Attribute** | **Type**  |
|---------------|-----------|
| courseId      | Long      |
| title         | String    |
| credit        | Integer   |
| teacher       | Teacher   |
| courseMaterial| CourseMaterial |
| students      | List<Student> |

---

### CourseMaterial
| **Attribute**     | **Type**  |
|--------------------|-----------|
| courseMaterialId   | Long      |
| url                | String    |
| course             | Course    |

---

### Relationships Summary
- **Guardian ↔ Student**: One-to-Many
- **Student ↔ Course**: Many-to-One
- **Teacher ↔ Course**: One-to-Many
- **Course ↔ CourseMaterial**: One-to-One
- **Course ↔ Student**: One-to-Many


- **Guardian ↔ Student**: One-to-Many
- **Student ↔ Course**: Many-to-One
- **Teacher ↔ Course**: One-to-Many
- **Course ↔ CourseMaterial**: One-to-One
- **Course ↔ Student**: One-to-Many
