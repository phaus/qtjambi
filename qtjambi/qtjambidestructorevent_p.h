#ifndef QTJAMBIDESTRUCTOREVENT_H
#define QTJAMBIDESTRUCTOREVENT_H

//
//  W A R N I N G
//  -------------
//
// This file is not part of the Qt Jambi API. 
// This header file may change from version to version without notice, 
// or even be removed.
//
// We mean it.
//
//

#include "qtjambilink.h"

#include <QEvent>

class QtJambiDestructorEvent : public QEvent
{

public:
    QtJambiDestructorEvent(void *pointer, int meta_type, int ownership, PtrDestructorFunction destructor_function)
	: QEvent( QEvent::Type(513) ), 
	  m_pointer(pointer),
      m_meta_type(meta_type),
	  m_ownership(ownership),
	  m_destructor_function(destructor_function)
    { }
        
    inline void callDestructor() 
    {
	    if (m_pointer != 0 && m_meta_type != QMetaType::Void) {
	        QMetaType::destroy(m_meta_type, m_pointer);
	    } else if (m_ownership == QtJambiLink::JavaOwnership && m_destructor_function) {
	        m_destructor_function(m_pointer);
	    }
	    m_pointer = 0; 
    }
    
private:
    void * m_pointer;
    int m_meta_type;
    int m_ownership;
    PtrDestructorFunction m_destructor_function;
};

#endif