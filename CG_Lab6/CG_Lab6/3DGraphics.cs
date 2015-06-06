using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CG_Lab6
{
    namespace Graphics_Lab6
    {

        public class Point3D
        {
            public double X { get; set; }
            public double Y { get; set; }
            public double Z { get; set; }

            public Point3D() : this(0, 0, 0) { }

            public Point3D(double x, double y, double z)
            {
                X = x;
                Y = y;
                Z = z;
            }

            public Point3D(Point3D point) : this(point.X, point.Y, point.Z) { }

            public double[,] GetVector4D()
            {
                double[,] result = new double[4, 1];
                result[0, 0] = X;
                result[1, 0] = Y;
                result[2, 0] = Z;
                result[3, 0] = 1;
                return result;
            }
        }

        public class Segment
        {
            public Point3D PointA { get; set; }
            public Point3D PointB { get; set; }

            public Segment() : this(0, 0, 0, 0, 0, 0) { }

            public Segment(double x1, double y1, double z1, double x2, double y2, double z2)
            {
                PointA = new Point3D(x1, y1, z1);
                PointB = new Point3D(x2, y2, z2);
            }

            public Segment(Segment segment) : this(segment.PointA.X, segment.PointA.Y, segment.PointA.Z, segment.PointB.X, segment.PointB.Y, segment.PointB.Z) { }
        }
    }
}
