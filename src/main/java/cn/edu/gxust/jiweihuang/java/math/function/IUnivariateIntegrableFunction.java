/*
 * Copyright (c) 2018-2019, Jiwei Huang. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cn.edu.gxust.jiweihuang.java.math.function;

import org.hipparchus.analysis.integration.*;

public interface IUnivariateIntegrableFunction extends IUnivariateFunction {
    default double integrateRomberg(double x0, double x1) {
        return (new RombergIntegrator()).integrate(Integer.MAX_VALUE, this, x0, x1);
    }

    default double integrateRomberg(double x1) {
        return integrateRomberg(lowerX(), x1);
    }

    default double integrateRomberg() {
        return integrateRomberg(lowerX(), upperX());
    }

    default double integrateSimpson(double x0, double x1) {
        return (new SimpsonIntegrator()).integrate(Integer.MAX_VALUE, this, x0, x1);
    }

    default double integrateSimpson(double x1) {
        return integrateSimpson(lowerX(), x1);
    }

    default double integrateSimpson() {
        return integrateSimpson(lowerX(), upperX());
    }

    default double integrateMidPoint(double x0, double x1) {
        return (new MidPointIntegrator()).integrate(Integer.MAX_VALUE, this, x0, x1);
    }

    default double integrateMidPoint(double x1) {
        return integrateMidPoint(lowerX(), x1);
    }

    default double integrateMidPoint() {
        return integrateMidPoint(lowerX(), upperX());
    }

    default double integrateTrapezoid(double x0, double x1) {
        return (new TrapezoidIntegrator()).integrate(Integer.MAX_VALUE, this, x0, x1);
    }

    default double integrateTrapezoid(double x1) {
        return integrateTrapezoid(lowerX(), x1);
    }

    default double integrateTrapezoid() {
        return integrateTrapezoid(lowerX(), upperX());
    }

    default double integrateIterativeLegendreGauss(double x0, double x1) {
        return (new IterativeLegendreGaussIntegrator(Integer.MAX_VALUE,
                BaseAbstractUnivariateIntegrator.DEFAULT_RELATIVE_ACCURACY,
                BaseAbstractUnivariateIntegrator.DEFAULT_ABSOLUTE_ACCURACY)).integrate(Integer.MAX_VALUE, this, x0, x1);
    }

    default double integrateIterativeLegendreGauss(double x1) {
        return integrateIterativeLegendreGauss(lowerX(), x1);
    }

    default double integrateIterativeLegendreGauss() {
        return integrateIterativeLegendreGauss(lowerX(), upperX());
    }
}
