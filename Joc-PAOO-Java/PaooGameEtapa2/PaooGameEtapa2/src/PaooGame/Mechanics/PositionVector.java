package PaooGame.Mechanics;

/*! \class PositionVector
    \brief Implementeaza notiunea de vector cu o pozitie x si y.
 */

public class PositionVector {
    float x;
    float y;

    /*! \fn PositionVector()
        \brief Constructor implicit de initializare al clasei PositionVector.
     */

    PositionVector()
    {
        x=0.0f;
        y=0.0f;
    }

    /*! \fn Position Vector(float x, float y)
        \brief Constructor cu parametrii de initializare al clasei PositionVector.
     */

    PositionVector(float x,float y)
    {
        this.x=x;
        this.y=y;
    }


}
