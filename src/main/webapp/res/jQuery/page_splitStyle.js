var broswerFlag;
var parentTopHeight = 0;
jQuery(function() {
	if (window.navigator.userAgent.indexOf("MSIE") >= 1) {
        var a = window.navigator.userAgent.substring(30, 33);
        if (a == "6.0") {
            broswerFlag = "IE6"
        } else {
            if (a == "7.0") {
                broswerFlag = "IE7"
            } else {
                if (a == "8.0") {
                    broswerFlag = "IE8"
                }
            }
        }
    } else {
        if (window.navigator.userAgent.indexOf("Firefox") >= 1) {
            broswerFlag = "Firefox"
        } else {
            if (window.navigator.userAgent.indexOf("Opera") >= 0) {
                broswerFlag = "Opera"
            } else {
                if (window.navigator.userAgent.indexOf("Safari") >= 1) {
                    broswerFlag = "Safari"
                } else {
                    broswerFlag = "Other"
                }
            }
        }
    }
    
	/** 按钮样式start **/
	var a;
	//页面加载时添加默认样式.
//	jQuery("input:button,input:submit,input:reset").each(function() {
//		//添加样式
//		jQuery(this).addClass("button");
//		//获取value长度.如果小于或等于5,则默认宽度为60px;
//		var c = _getStrLength(jQuery(this).val());
//		if (c <= 5) {
//			//设宽
//			jQuery(this).width(60)
//		}
//	});
//	//button存在样式时.鼠标移动或获取事件.
//	jQuery("input:button[class='button'],input:submit[class='button'],input:reset[class='button'],button[class='button']").each(function() {
//		//hover将两个事件处理程序绑定到元素对象的 mouseenter 和 mouseleave事件上,当鼠标指针进入和离开元素时执行该方法.
//		//获取鼠标焦点,并执行函数方法.
//		jQuery(this).hover(function() {
//			//判断该对象第一个元素[0]
//			if (a != jQuery(this)[0]) {
//				//改变该对象样式
//				jQuery(this).removeClass("button");
//				jQuery(this).addClass("button_hover")
//			}
//		},
//		//鼠标失去焦点后执行的元素方法.
//		function() {
//			//判断该对象第一个元素[0]
//			if (a != jQuery(this)[0]) {
//				//改变该对象样式
//				jQuery(this).removeClass("button_hover");
//				jQuery(this).addClass("button")
//			}
//		});
//		//鼠标获取焦点,改变默认样式.
//		jQuery(this).focus(function() {
//			//改变该对象样式
//			jQuery(this).removeClass("button");
//			jQuery(this).addClass("button_hover")
//		});
//		//鼠标失去焦点,触发该事件,移除样式返回默认样式
//		jQuery(this).blur(function() {
//			//改变该对象样式
//			jQuery(this).removeClass("button_hover");
//			jQuery(this).addClass("button")
//		})
//	});
	/** 按钮样式end **/
	
	/** 文本样式start **/
	//页面加载时添加默认样式.
//	jQuery("input:text[class=''],input:password[class='']").each(function() {
//	    jQuery(this).addClass("textinput");
//	    //hover将两个事件处理程序绑定到元素对象的 mouseenter 和 mouseleave事件上,当鼠标指针进入和离开元素时执行该方法.
//		//获取鼠标焦点,并执行函数方法.
//	    jQuery(this).hover(function() {
//	        if (a != jQuery(this)[0]) {
//	        	//删除样式
//	            jQuery(this).removeClass("textinput");
//	            //添加样式
//	            jQuery(this).addClass("textinput_hover")
//	        }
//	    },
//	    //鼠标失去焦点后执行的元素方法.
//	    function() {
//	        if (a != jQuery(this)[0]) {
//	            jQuery(this).removeClass("textinput_hover");
//	            jQuery(this).addClass("textinput")
//	        }
//	    });
//	    //鼠标获取焦点,改变默认样式.
//	    jQuery(this).focus(function() {
//	        a = jQuery(this)[0];
//	        jQuery(this).removeClass("textinput");
//	        jQuery(this).removeClass("textinput_hover");
//	        jQuery(this).addClass("textinput_click")
//	    });
//	    //鼠标失去焦点,触发该事件,移除样式返回默认样式
//	    jQuery(this).blur(function() {
//	        a = null;
//	        jQuery(this).removeClass("textinput_click");
//	        jQuery(this).addClass("textinput");
//	        //鼠标移除去掉前后空格
//	        jQuery(this).val(jQuery(this).val().replace(/(^\s*)|(\s*$)/g, ""));
//	    });
//	    //如果为密码框,则检测大小键是否打开,给出提示!
//        jQuery("input:password[class='textinput']").each(function() {
//        	//检索大写键是否开启
//		    jQuery(this).caps(function(b) {
//		    	//如果为safari浏览器,则返回.W3C、IE和safari浏览器不同标准
//	            if (jQuery.browser.safari) {
//	                return
//	            }
//	            //检索键是否开启 true or false
//	            if (b) {
//	            	//显示提示信息
//	                jQuery.cursorMessage("大写锁定已打开！")
//	            } else {
//	            	//隐藏
//	            	jQuery.hideCursorMessage();
//	            }
//	        })
//    	});
//    	//自动清除内容
//    	if (jQuery(this).attr("clearable") == "true") {
//    		jQuery(this).keyup(function(e) {
//		        jQuery(this).clearableTextField();
//		    });
//        };
//        var P = jQuery(this).attr("hintboxPath");
//        if (jQuery(this).attr("hintbox_list") == "true") {
//        	if (P =! null && P != undefined) {
//	        	jQuery(this).hintbox({
//			      	url: jQuery(this).attr("hintboxPath"),
//	      			json: true
//			    });
//        	}
//        };
//	});
	/** 文本样式end **/
	
	/** 文本域样式start **/
	//页面加载时添加默认样式.
//	jQuery("textarea").each(function() {
//		//如果样式为空,动态增加样式
//        if (jQuery(this).attr("class") == "") {
//            jQuery(this).addClass("textarea")
//        }
//        //高度自适应内容
//        if (jQuery(this).attr("autoHeight") == "true") {
//            jQuery(this).css({
//                height: "auto"
//            });
//            jQuery(this).attr("rows", 5);
//            jQuery(this).autoGrow()
//        }
//        //hover将两个事件处理程序绑定到元素对象的 mouseenter 和 mouseleave事件上,当鼠标指针进入和离开元素时执行该方法.
//		//获取鼠标焦点,并执行函数方法.
//        jQuery(this).hover(function() {
//            if (a !=jQuery(this)[0]) {
//               jQuery(this).removeClass("textarea");
//               jQuery(this).addClass("textarea_hover")
//            }
//        },
//        //鼠标失去焦点后执行的元素方法.
//        function() {
//            if (a !=jQuery(this)[0]) {
//               jQuery(this).removeClass("textarea_hover");
//               jQuery(this).addClass("textarea");
//            }
//        });
//        //鼠标获取焦点,改变默认样式.
//       	jQuery(this).focus(function() {
//            a =jQuery(this)[0];
//           jQuery(this).removeClass("textarea");
//           jQuery(this).removeClass("textarea_hover");
//           jQuery(this).addClass("textarea_click");
//        });
//        //鼠标失去焦点,触发该事件,移除样式返回默认样式
//      	jQuery(this).blur(function() {
//            a = null;
//           jQuery(this).removeClass("textarea_click");
//           jQuery(this).addClass("textarea");
//           //鼠标移除去掉前后空格
//	       jQuery(this).val(jQuery(this).val().replace(/(^\s*)|(\s*$)/g, ""));
//       });
//    });
    /** 文本域样式end **/

    /** 复选 + 单选按钮start **/
    //页面加载时添加默认样式.
//    jQuery("input:checkbox[class=''],input:radio[class='']").each(function(){
//			jQuery(this).select_element();
//    });
//    /** 复选 + 单选按钮end **/
//    
//     /** 下拉列表start **/
//    //页面加载时添加默认样式.
//    jQuery("select").each(function() {
//        if (jQuery(this).attr("class") == "") {
//             jQuery(this).selectbox()
//        }
//    });
    /** 下拉列表end **/
});
/**
 * 创建提示信息
 */
if (jQuery) { 
	(function(a) {
		//创建数组
	    a.cursorMessageData = {};
	    //页面加载调用
	    a(window).ready(function(b) {
	    	//判断DIV是否存在,不存在则创建
	        if (a("#cursorMessageDiv").length == 0) {
	        	//创建
	            a("body").append('<div id="cursorMessageDiv" class="cursorMessageDiv">&nbsp;</div>');
	            //隐藏
	            a("#cursorMessageDiv").hide()
	        }
	        //body区域获取鼠标X/Y坐标点
	        a("body").mousemove(function(c) {
	        	//鼠标X/Y坐标点
	            a.cursorMessageData.mouseX = c.pageX;
	            a.cursorMessageData.mouseY = c.pageY;
	            //如果存在及显示出来
	            if (a.cursorMessageData.options != undefined) {
	                a._showCursorMessage()
	            }
	        })
	    });
	    //重载jquery方法
	    a.extend({
	    	//淡出效果
	        cursorMessage: function(c, b) {
	        	//基本属性
	            if (b == undefined) {
	                b = {}
	            }
	            //坐标点X位置
	            if (b.offsetX == undefined) {
	                b.offsetX = 5
	            }
	            //坐标点Y位置
	            if (b.offsetY == undefined) {
	                b.offsetY = 5
	            }
	            //淡出效果时间,默认为1秒
	            if (b.hideTimeout == undefined) {
	                b.hideTimeout = 9000
	            }
	            //淡出提示信息,增加显示内容
	            a("#cursorMessageDiv").html(c).fadeIn("slow");
	            //鼠标信息位置占停事件
	            if (jQuery.cursorMessageData.hideTimeoutId != undefined) {
	            	//延迟鼠标
	                clearTimeout(jQuery.cursorMessageData.hideTimeoutId)
	            }
	            /** 延迟提示信息隐藏
	            if (b.hideTimeout > 0) {
	            	//给鼠标坐标点占停绑定事件
	                jQuery.cursorMessageData.hideTimeoutId = setTimeout(a.hideCursorMessage, b.hideTimeout)
	            }
	            **/
	            //给鼠标信息位置增加选项
	            jQuery.cursorMessageData.options = b;
	            //追加样式属性.DIV显示位置
	            a._showCursorMessage()
	        },
	        hideCursorMessage: function() {
	        	//淡入效果隐藏提示信息
	            a("#cursorMessageDiv").fadeOut("slow")
	        },
	        //淡出效果样式\位置
	        _showCursorMessage: function() {
	        	//设定DIV提示信息坐标点,显示区域.
	            a("#cursorMessageDiv").css({
	                top: (a.cursorMessageData.mouseY + a.cursorMessageData.options.offsetY) + "px",
	                left: (a.cursorMessageData.mouseX + a.cursorMessageData.options.offsetX)
	            })
	        }
	    })
	})(jQuery);
};
/**
 * 键盘事件
 * @param {} a
 * @return {}
 */
jQuery.fn.caps = function(a) {
    return this.keypress(function(f) {
        var b = f.which ? f.which: (f.keyCode ? f.keyCode: -1);
        var d = f.shiftKey ? f.shiftKey: (f.modifiers ? !!(f.modifiers & 4) : false);
        var g = ((b >= 65 && b <= 90) && !d) || ((b >= 97 && b <= 122) && d);
        a.call(this, g)
    })
};
/**
 * 自动清除文本内容
 */
(function(d) {
    d.fn.clearableTextField = function() {
        if (d(this).length > 0) {
            for (var f = 0; f < d(this).length; f++) {
                c(d(d(this)[f]))
            }
        }
    };
    function e() {
        c(d(this))
    }
    //判断文本内是否有值存在
    function c(f) {
        if (f.val().length > 0) {
            b(f)
        } else {
            a(f)
        }
    }
    function b(i) {
    	//如果按钮键不存在,则创建
        if (!i.next().hasClass("text_clear_button")) {
        	//创建DIV显示区域
            i.after("<div class='text_clear_button' title=\"清除文本内容.\"></div>");
            var f = i.next();
            var g = f.outerHeight(),k = f.outerHeight();
            i.css("padding-right", parseInt(i.css("padding-right")) + g + 1);
            var m = i.position();
            var j = {};
            j.left = m.left + i.outerWidth(false) - (g + 2);
            var l = Math.round((i.outerHeight(true) - k) / 2);
            j.top = m.top + d("#scrollContent").scrollTop() + l;
            f.css(j);
            //图片按钮追加点击事件,清空内容,并递归
            f.click(function() {
                i.val("");
                c(i)
            })
        }
    }
    //如文本内容清除,则删除图片
    function a(h) {
        var f = h.next();
        if (f.hasClass("text_clear_button")) {
            f.remove();
        }
    }
})(jQuery);
/**
 * 自动完成内容
 */
(function(a) {
	//重载方法
	a.fn.hintbox = function(g) {
		inputs = this;
		var c = {
			ENTER: 13,
			LEFT: 37,
			UP: 38,
			RIGHT: 39,
			DOWN: 40,
			SPACE: 32,
			PAGEDOWN: 34
		};
		var f = {
			STARTS_WITH: "S",
			ENDS_WITH: "E",
			CONTAINS: "C"
		};
		//默认属性
		var n = {
			backgroundColor: "#3369F9",
			color: "#FFF",
			autoDimentions: false,
			minChars: 1,
			immediateList: false,
			width: "250px",
			height: "160px",
			separator: "\n",
			delay: 400,
			slideDownTime: 0,
			slideUpTime: 0,
			inputClass: "",
			inputLoadingClass: "hintbox_loading",
			hintboxContainerClass: "hintbox_list_container",
			zIndex: 600,
			url: "",
			params: {},
			extraParams: "",
			json: false,
			useCache: true,
			matchHint: true,
			matchRule: f.STARTS_WITH,
			sort: false,
			limit: 0,
			onBeforeListLoad: function() {},
			onListRetrieved: function() {},
			onListLoaded: function() {},
			onItemSelected: function() {}
		};
		if (g.matchRule != undefined) {
			g.matchRule = g.matchRule.toUpperCase();
			if (g.matchRule != f.STARTS_WITH && g.matchRule != f.ENDS_WITH && g.matchRule != f.CONTAINS) {
				g.matchRule = n.matchRule
			}
		}
		//重载控件
		var g = jQuery.extend(n, g);
		var A = function(F, E) {
			var H;
			var G;
			var J;
			var I = new Array();
			if (F.length == 0) {
				return E.length
			}
			if (E.length == 0) {
				return F.length
			}
			for (H = 0; H <= F.length; H++) {
				I[H] = new Array();
				I[H][0] = H
			}
			for (G = 0; G <= E.length; G++) {
				I[0][G] = G
			}
			for (H = 1; H <= F.length; H++) {
				for (G = 1; G <= E.length; G++) {
					J = (F.charAt(H - 1) == E.charAt(G - 1)) ? 0: 1;
					I[H][G] = Math.min(I[H - 1][G] + 1, I[H][G - 1] + 1, I[H - 1][G - 1] + J);
					if (H > 1 && G > 1 && F.charAt(H - 1) == E.charAt(G - 2) && F.charAt(H - 2) == E.charAt(G - 1)) {
						I[H][G] = Math.min(I[H][G], I[H - 2][G - 2] + J)
					}
				}
			}
			return I[F.length][E.length]
		};
		var k = function(E) {
			jQuery(document).bind("keydown",
			function(F) {
				m(F, E)
			})
		};
		var d = function() {
			jQuery(document).unbind("keydown")
		};
		var z = function(E) {
			d();
			k(E)
		};
		var r = function(E) {
			return q(E).find("ul")
		};
		var q = function(E) {
			return E.next("." + g.hintboxContainerClass)
		};
		var D = function(E) {
			return q(E).get() != ""
		};
		var t = function(E) {
			E.attr("autocomplete", "off");
			var G = "";
			var F = "";
			E.keyup(function(I) {
				if (I.keyCode != c.UP && I.keyCode != c.DOWN && I.keyCode != c.ENTER && I.keyCode != c.LEFT && I.keyCode != c.RIGHT && I.keyCode != c.PAGEDOWN) {
					F = jQuery.trim(E.val());
					if (F == "") {
						q(E).slideUp(g.slideUpTime)
					} else {
						if (F != G) {
							if (F.length >= g.minChars) {
								setTimeout(function() {
									x(E, F)
								},
								g.delay)
							} else {
								q(E).slideUp(g.slideUpTime)
							}
						}
					}
					G = F
				}
				if (I.keyCode == c.ENTER) {
					G = "";
					F = "";
					var H = q(E);
					if (H.get() != "") {
						h(E)
					}
				}
				if (g.immediateList) {
					if (I.keyCode == c.PAGEDOWN) {
						F = jQuery.trim(E.val());
						if (F == "") {
							x(E, F)
						}
					}
				}
			})
		};
		var s = function(E) {
			if (D(E)) {
				var F = r(E);
				//LI点击事件,并把选中值放置入文本框中
				F.find("li").click(function() {
					var G = jQuery(this);
					E.val(G.text());
					h(E);
					g.onItemSelected(G);
					jQuery(E).clearableTextField();
				})
			}
		};
		var m = function(E, J) {
			if (D(J)) {
				var G = jQuery.data(J, "cssBackup");
				var H = r(J);
				var K = H.find("li:first");
				var M = H.find("li:last");
				var F = H.find(".selected");
				if (F.get() == "") {
					if (E.keyCode == c.DOWN) {
						F = K
					} else {
						if (E.keyCode == c.UP) {
							F = M
						}
					}
					b(F);
					return
				}
				if (E.keyCode == c.DOWN) {
					B(F, G);
					var L = F.next("li");
					if (L.get() == "") {
						L = K;
						J.focus();
						H.find(".selected").removeClass("selected")
					} else {
						F = L;
						b(F)
					}
				} else {
					if (E.keyCode == c.UP) {
						B(F, G);
						var I = F.prev("li");
						if (I.get() == "") {
							I = M;
							J.focus();
							H.find(".selected").removeClass("selected")
						} else {
							b(I);
							F = I
						}
					} else {
						if (E.keyCode == c.ENTER) {
							if (F.get() != "") {
								J.val(F.text())
							}
							h(J);
							g.onItemSelected(F)
						}
					}
				}
			}
		};
		var l = function(G) {
			var E = g.url;
			//inputVal 为后台获取参数
			E.indexOf("?") != -1 ? E += "&": E += "?";
			E += "inputVal=" + (G);//escape
			for (i in g.params) {
				E += "&" + i + "=" + (jQuery.trim(g.params[i]))//escape
			}
			var F = jQuery.trim(g.extraParams);
			if (F.length > 0) {
				if (F.indexOf("&") > 0) {
					E += "&" + F
				} else {
					E += F
				}
			}
			return E
		};
		var C = function() {
			var E = jQuery(document).data("hintbox_cache");
			if (E == undefined) {
				var E = new Array();
				E.getItem = function(F) {
					return this[F]
				};
				E.putItem = function(F, G) {
					this[F] = G
				};
				E.hasItem = function(F) {
					if (this[F] == undefined) {
						return false
					}
					return true
				};
				jQuery(document).data("hintbox_cache", E)
			}
			return E
		};
		//创建下拉显示层
		var p = function(G, I, H) {
			G.removeClass(g.inputLoadingClass);
			if (H.length > 0) {
				var E = (typeof H == "object" ? H: H.split(g.separator));
				g.onListRetrieved(E);
				if (g.useCache) {
					var F = C();
					if (!F.hasItem(I)) {
						F.putItem(I, E)
					}
				}
				e(G, E);
				var J = {
					backgroundColor: r(G).find("li").css("background-color"),
					color: r(G).find("li").css("color")
				};
				jQuery.data(G, "cssBackup", J);
				o(G);
				u(G);
				j(G);
				z(G);
				s(G);
				g.onListLoaded(r(G))
			}
		};
		var x = function(G, I) {
			if (g.immediateList || I.length >= g.minChars) {
				var H = l(I);
				//url
				H = encodeURI(H);
				H = encodeURI(H);
				G.addClass(g.inputLoadingClass);
				g.onBeforeListLoad();
				var E = null;
				if (g.useCache) {
					var F = C();
					if (F.hasItem(H)) {
						E = F.getItem(H)
					}
				}
				if (E == null) {
					//判断是否使用json格式返回
					if (!g.json) {
						//使用AJAX获取值
						jQuery.ajax({
							url: H,
							success: function(J) {
								//创建显示层
								p(G, H, jQuery.trim(J))
							}
						})
					} else {
						//使用json格式方法,则调用并创建
						jQuery.getJSON(H,
						function(M) {
							var N = "";
							var L = jQuery(M.list);
							var K = L.size();
							var J = 1;
							L.each(function() {
								N += this;
								if (J < K) {
									N += g.separator
								}
								J++
							});
							p(G, H, N)
						})
					}
				} else {
					p(G, H, E)
				}
			}
		};
		var v = function(F) {
			var J = F.offset();
			var E = q(F);
			var I = r(F);
			var H = 0;
			if (a("#scrollContent").attr("offsetLeft") != null) {
				H = parseInt(a("#scrollContent").attr("offsetLeft"))
			}
			var G = 0;
			if (a("#scrollContent").length > 0) {
				G = a("#scrollContent").scrollTop()
			}
			E.css({
				display: "block",
				position: "absolute",
				top: J.top + G + F.outerHeight() - parseInt(F.css("border-bottom-width")),
				left: J.left - H - parseInt(I.css("border-left-width")) + parseInt(F.css("border-left-width"))
			})
		};
		var y = function(H, E) {
			var K = jQuery.trim(H.val());
			var G = new Array();
			var J = 0;
			jQuery.each(E,
			function() {
				var M = A(K, jQuery.trim(this));
				if (G[J] == undefined) {
					G[J] = new Array()
				}
				G[J] = new Array(M, jQuery.trim(this));
				J++
			});
			var L = function(O, N) {
				if (parseInt(G[N]) < parseInt(G[O])) {
					var M = G[O];
					G[O] = G[N];
					G[N] = M;
					if (O > 0) {
						L(O - 1, O)
					}
				}
			};
			for (var I = 0; I < G.length - 1; I++) {
				L(I, I + 1)
			}
			E = new Array();
			for (var I = 0; I < G.length; I++) {
				var F = G[I];
				E.push(F[1])
			}
			return E
		};
		var w = function(G, F) {
			var H = jQuery.trim(G.val());
			var E = new Array();
			jQuery.each(F,
			function() {
				var I = jQuery.trim(this).toLowerCase();
				var J = H.toLowerCase();
				if (g.matchRule == f.STARTS_WITH) {
					if (I.match("^" + J) == J) {
						E.push(jQuery.trim(this))
					}
				} else {
					if (g.matchRule == f.ENDS_WITH) {
						if (I.match(J + "$") == J) {
							E.push(jQuery.trim(this))
						}
					} else {
						if (I.match(J) == J) {
							E.push(jQuery.trim(this))
						}
					}
				}
			});
			return E
		};
		var e = function(G, E) {
			var F = q(G);
			var I;
			if (F.get() == "") {
				//创建DIV层,并赋值属性样式
				F = jQuery("<div></div>").addClass(g.hintboxContainerClass).css({
					margin: 0,
					padding: 0,
					display: "none",
					"z-index": g.zIndex
				});
			} else {
				F.empty()
			}
			//创建DIV层中的UI对象
			var H = jQuery("<ul></ul>").css({
				cursor: "default"
			});
			if (g.sort) {
				E = y(G, E)
			}
			if (g.limit > 0) {
				E = E.slice(0, g.limit)
			}
			//如果内容不等于空,则创建li中显示值
			jQuery.each(E,function() {
				H.append(jQuery("<li></li>").text(jQuery.trim(this)))
			});
			//包含到Div中
			F.append(H);
			//插入到面板中
			G.after(F);
			v(G);
			F.slideDown(g.slideDownTime)
		};
		var o = function(H) {
			var I = r(H);
			//如果li值有,则给其增加样式属性
			if (I.find("li").length > 0) {
				if (g.autoDimentions) {
					var F = parseInt(H.css("border-left-width"));
					var G = parseInt(H.css("border-right-width"));
					var E = H.outerWidth();
					g.width = (E - F - G) + "px";
					I.find("li").css({
						"line-height": H.outerHeight() + "px"
					})
				}
				//增加li属性值
				I.css({
					width: g.width,
					height:parseInt(g.height) + parseInt(20),
					"overflow-y": "auto"
				})
			} else {
				//删除LI,释放资源
				I.remove()
			}
		};
		var h = function(F) {
			d();
			var E = q(F);
			E.slideUp(g.slideUpTime,
			function() {
				jQuery(this).remove()
			})
		};
		var j = function(E) {
			var F = r(E);
			var G = jQuery.data(E, "cssBackup");
			F.find("li").hover(function() {
				B(F.find(".selected"), G);
				b(jQuery(this))
			},
			function() {
				B(jQuery(this), G)
			})
		};
		var b = function(E) {
			E.css({
				"background-color": g.backgroundColor,
				color: g.color
			});
			E.addClass("selected")
		};
		var B = function(E, F) {
			E.css({
				"background-color": F.backgroundColor,
				color: F.color
			});
			E.removeClass("selected")
		};
		var u = function(E) {
			if (!jQuery.support.boxModel) {
				var w = (parseInt(g.width) + parseInt(E.css("border-left-width")) * 2)+80;
				r(E).css({
					width: w + "px"
				}).find("li").css({
					width: w - 2 + "px"
				})
			}
		};
		//给与控件赋值方法
		jQuery(inputs).each(function() {
			var E = jQuery(this);
			if (!E.hasClass(g.inputClass)) {
				E.addClass(g.inputClass)
			}
			t(E);
			E.click(function() {
				z(E)
			});
			E.focus(function() {
				z(E)
			});
			E.blur(function() {
				z(E)
			})
		});
		return inputs
	}
})(jQuery);
/**
 * 文本域
 * 高度自适应内容
 * @return {}
 */
jQuery.fn.autoGrow = function() {
    return this.each(function() {
        setDefaultValues(this);
        bindEvents(this)
    })
}; 
/**
 * 获取文本域行数
 * @param {} a
 */
function setDefaultValues(a) {
    colsDefault = a.cols;
    rowsDefault = jQuery(a).attr("rows")
}
/**
 * 追加键盘事件,监听文本域操作
 * @param {} a
 */
function bindEvents(a) {
	a.onkeyup = function() {
	    grow(a)
	}
}
/**
 * 追加文本域行数,达到内容高度.
 * @param {} d
 */
function grow(d) {
    var c = 0;
    //截取对象value值行数.
    var a = d.value.split("\n");
    for (var b = a.length - 1; b >= 0; --b) {
        c += Math.floor((a[b].length / colsDefault) + 1)
    }
    //追加文本域高度行数
    if (c >= rowsDefault) {
        d.rows = c + 1
    } else {
        d.rows = rowsDefault
    }
}
/**
 * 单选与复选框按钮
 */
(function(a) {
	a.fn.select_element = function(b){
		//重载方法
		var c = a.extend(b);
		//返回对象
        return this.each(function() {
            var e = a(this);
            a.fn.buildbox = function(f) {
            	//判断浏览器,加载不同样式标准
                if (broswerFlag == "IE6" || broswerFlag == "IE7" || broswerFlag == "IE8") {
                    a(f).css({
                        display: "none"
                    }).before('<span class="cust_checkbox">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>')
                } else {
                    a(f).css({
                        display: "none"
                    }).before('<span class="cust_checkbox">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>')
                }
                //对象默认状态属性
                var i = a(f).attr("checked");//复选框
                var g = a(f).attr("type");//对象类型
                var h = a(f).attr("disabled");//是否禁用
                //区分复选框 与 单选框 样式列表
                if (g == "checkbox") {
                	//遍历检索该checkbox对象
                    a(f).prev("span").addClass("checkbox");
                    if (h) {
                        g = "checkbox_disabled"
                    }
                } else {
                	//遍历检索该radio对象
                    a(f).prev("span").addClass("radio");
                    if (h) {
                        g = "radio_disabled"
                    }
                }
                //复选框 与 单选框 加入样式列表
                if (i) {
                    a(f).prev("span").addClass("cust_" + g + "_on")
                } else {
                    a(f).prev("span").addClass("cust_" + g + "_off")
                }
                //相对应的lable加入连点事件,遍历检索该对象并移除被选元素
                a(f).prev("span").prev("label").unbind().click(function() {
                    if (a(f).attr("onclick") != null) {
                        a(a(f).attr("onclick"))
                    }
                    //next 获得匹配元素集合中每个元素紧邻的同胞元素
                    var l = a(this).next("span");//html元素
                    var j = a(l).next("input").attr("type");//对象类型
                    var k = a(l).next("input").attr("disabled");//对象属性:是否仅有那个
                    //检查元素是否包含"checkbox" 类,用于给复选框加入样式
                    if (a(l).hasClass("checkbox")) {
                    	//检测对象样式、该对象是否被禁用
                        if (a(l).hasClass("cust_" + j + "_off") && !k) {
                        	//判断浏览器,加载不同样式标准
                            if (broswerFlag == "IE6" || broswerFlag == "IE7" || broswerFlag == "IE8") {
                                a(l).removeClass("cust_" + j + "_off").removeClass("cust_" + j + "_hvr").addClass("cust_" + j + "_on").next("input").attr("checked", "checked")
                            } else {
                                a(l).removeClass("cust_" + j + "_off").removeClass("cust_" + j + "_hvr").addClass("cust_" + j + "_on").next("input").removeAttr("checked")
                            }
                        } else {
                        	//控件未被禁用状态下
                            if (!k) {
                            	//判断浏览器,加载不同样式标准
                                if (broswerFlag == "IE6" || broswerFlag == "IE7" || broswerFlag == "IE8") {
                                    a(l).removeClass("cust_" + j + "_on").removeClass("cust_" + j + "_hvr").addClass("cust_" + j + "_off").next("input").removeAttr("checked")
                                } else {
                                    a(l).removeClass("cust_" + j + "_on").removeClass("cust_" + j + "_hvr").addClass("cust_" + j + "_off").next("input").attr("checked", "checked")
                                }
                                a(l).removeClass("cust_" + j + "_hvr")
                            }
                        }
                    } else {
                        if (!k) {
                        	//样式切换
                            a(l).parent().find(".cust_checkbox").removeClass("cust_" + j + "_on").addClass("cust_" + j + "_off").next("input").removeAttr("checked");
                            a(l).removeClass("cust_" + j + "_off").addClass("cust_" + j + "_on").next("input").attr("checked", "checked");
                            a(l).removeClass("cust_" + j + "_hvr")
                        }
                    }
                }).hover(function() {
                    var j = a(this).next("span");
                    //样式切换
                    if (a(j).hasClass("cust_checkbox_off") && c.hover) {
                        a(j).addClass("cust_checkbox_hvr")
                    } else {
                        if (a(j).hasClass("cust_radio_off") && c.hover) {
                            a(j).addClass("cust_radio_hvr")
                        }
                    }
                },
                function() {
                	//遍历检索对象
                    var j = a(this).next("span");
                    //样式切换
                    if (a(j).hasClass("cust_checkbox_off") && c.hover) {
                        a(j).removeClass("cust_checkbox_hvr")
                    } else {
                        if (a(j).hasClass("cust_radio_off") && c.hover) {
                            a(j).removeClass("cust_radio_hvr")
                        }
                    }
                });
                //取消选中的复选框或者单选框
                a(f).prev("span").unbind().click(function() {
                	//追加标题与控件之间的勾选事件
                    if (a(f).attr("onclick") != null) {
                        a(a(f).attr("onclick"))
                    }
                    //获取对象类型
                    var j = a(this).next("input").attr("type");
                    //获取对象是否禁用
                    var k = a(this).next("input").attr("disabled");
                    //判断是否是复选框
                    if (a(this).hasClass("checkbox")) {
                    	//判断该样式 或 该对象是否是禁用状态
                        if (a(this).hasClass("cust_" + j + "_off") && !k) {
                        	//去除该对象中样式,并赋值新样式
                            a(this).removeClass("cust_" + j + "_off").removeClass("cust_" + j + "_hvr").addClass("cust_" + j + "_on").next("input").attr("checked", "checked")
                        } else {
                            if (!k) {
                            	//样式切换
                                a(this).removeClass("cust_" + j + "_on").removeClass("cust_" + j + "_hvr").addClass("cust_" + j + "_off").next("input").removeAttr("checked");
                                a(this).removeClass("cust_" + j + "_hvr")
                            }
                        }
                    } else {
                        if (!k) {
                        	//样式切换
                            a(this).parent().find(".cust_checkbox").removeClass("cust_" + j + "_on").removeClass("cust_" + j + "_hvr").addClass("cust_" + j + "_off").next("input").removeAttr("checked");
                            a(this).removeClass("cust_" + j + "_off").removeClass("cust_" + j + "_hvr").addClass("cust_" + j + "_on").next("input").attr("checked", "checked")
                        }
                    }
                }).hover(function() {
                	//样式切换
                    if (a(this).hasClass("cust_checkbox_off") && c.hover) {
                        a(this).addClass("cust_checkbox_hvr")
                    } else {
                        if (a(this).hasClass("cust_radio_off") && c.hover) {
                            a(this).addClass("cust_radio_hvr")
                        }
                    }
                },
                function() {
                	//样式切换
                    if (a(this).hasClass("cust_checkbox_off") && c.hover) {
                        a(this).removeClass("cust_checkbox_hvr")
                    } else {
                        if (a(this).hasClass("cust_radio_off") && c.hover) {
                            a(this).removeClass("cust_radio_hvr")
                        }
                    }
                })
            };
            //递归加载
            a.fn.buildbox(a(e))
        })
	};
})(jQuery);
function radioRefresh(a) {
    var b;
    if (typeof(a) == "object") {
        b = a
    } else {
        b = $("#" + a)
    }
    b.find("span").remove();
    b.find("input:radio[class='']").select_element()
};
function checkRefresh(a) {
    var b;
    if (typeof(a) == "object") {
        b = a
    } else {
        b = $("#" + a)
    }
    b.find("span").remove();
    b.find("input:checkbox[class='']").select_element()
};
/**
 * 检测value值长度
 * @param {} c 参数:value
 * @return {} a :返回值长度
 */
function _getStrLength(c) {
	var b;
	var a;
	for (b = 0, a = 0; b < c.length; b++) {
		if (c.charCodeAt(b) < 128) {
			a++
		} else {
			a = a + 2
		}
	}
	return a
};
/**
 * 重载下拉列表方法
 */
jQuery.fn.extend({
    selectbox: function(a) {
        return this.each(function() {
            new jQuery.SelectBox(this, a)
        })
    }
});
/**
 * 变量:显示层次
 * @type Number
 */
var depth = 500;
/**
 * 变量:用于创建ID
 * @type Number
 */
var elm_id = 1;
/**
 * 是否级联
 * @type 
 */
var cascade;

/**
 * 生成下拉列表 
 * @param {} F
 * @param {} g
 */
jQuery.SelectBox = function(F, g) {
    var c = g || {};
    //默认样式
    c.inputClass = c.inputClass || "selectbox";
    c.containerClass = c.containerClass || "selectbox-wrapper";
    c.hoverClass = c.hoverClass || "current";
    c.currentClass = c.selectedClass || "selected";
	var i = 0;
    var A = jQuery(F);
    var x = k(c);
    var p = B();
    var d = q(c);
    var w = false;
    var D;
    var C;
    var G = 0;
    /**
	 * ajax 级联：绑定对象ID
	 * @type 
	 */
	var bindingobject;
    //ID增+1
    elm_id++;
    //判断系统是否为windos XP 系统
    if (window.navigator.userAgent.indexOf("Windows") > -1) {
        G = 1
    }
    //获取对象宽度
    C = A.width();
    //如果为0,则默认加入宽度
    if (C == "0") {
        C = 120
    }
    //变量:按钮对象
    var n;
    //等于window系统
    if (G == 1) {
    	//兼容浏览器
        if (broswerFlag == "Firefox") {
            n = jQuery("<input type='button' value=' ' class='selBtn_safari'/>")
        } else {
            n = jQuery("<input type='button' value=' ' class='selBtn'/>")
        }
    } else {
        n = jQuery("<input type='button' value=' ' class='selBtn_linux'/>")
    }
    var u = jQuery("<div class='loader'>数据加载中...</div>");
    //级联绑定对象ID
    if (A.attr("bindingobject") != null && A.attr("bindingobject") != undefined) {
        bindingobject = true
    }
    //下拉层宽度
    if (w) {
        d.width(C - 20);
        x.width(C + 6)
    } else {
    	//下拉框默认值
        d.width(122);
        //默认层宽
		var f = 140;
        var b = Number(C);
        //自定义下拉宽度
        if (A.attr("aotuwidth") != null && A.attr("aotuwidth") != undefined) {
	        //取最大值
	        x.width(Math.max(A.attr("aotuwidth"), b))
        }else{
	        //取最大值
	        x.width(Math.max(f, b))
        }
    }
    //生成样式
    p.append(d);
    p.append(n);
    p.append(x);
    p.append(u);
    u.hide();
    //在该对象中插入样式
    A.hide().before(p);
    y();
    //文本区域
    d.click(function() {
        var L;
        var J = x.find("li").length;
        x.height(J * 18);
        if (broswerFlag == "IE8") {
            x.css({
                top: 23
            })
        } else {
            if (jQuery.browser.msie) {
                x.css({
                    top: 25
                })
            } else {
                x.css({
                    top: 19
                })
            }
        }
    }).focus(function() {
        if (x.not(":visible")) {
            depth++;
            p.css({
                zIndex: depth
            });
            e = true;
            setTimeout(H, 100)
        }
        function H() {
            x.show()
        }
    }).keydown(function(H) {
        switch (H.keyCode) {
        case 38:
            H.preventDefault();
            o( - 1);
            break;
        case 40:
            H.preventDefault();
            o(1);
            break;
        case 13:
            H.preventDefault();
            jQuery("li." + c.hoverClass).trigger("click");
            break;
        case 27:
            l();
            break
        }
    }).blur(function() {
         if (x.is(":visible") && D > 0) {
        } else {
            l()
        }
    });
    //左边按钮点击框
    n.click(function() {
        var L;
        var J = x.find("li").length;
        x.height(J * 18);
        if (broswerFlag == "IE8") {
            x.css({
                top: 23
            })
        } else {
            if (jQuery.browser.msie) {
                x.css({
                    top: 25
                })
            } else {
                x.css({
                    top: 19
                })
            }
        }
    }).focus(function() {
        if (x.not(":visible")) {
            depth++;
            p.css({
                zIndex: depth
            });
            e = true;
            setTimeout(H, 100)
        }
        function H() {
            x.show()
        }
    }).keydown(function(H) {
        switch (H.keyCode) {
        case 38:
            H.preventDefault();
            o( - 1);
            break;
        case 40:
            H.preventDefault();
            o(1);
            break;
        case 13:
            H.preventDefault();
            jQuery("li." + c.hoverClass).trigger("click");
            break;
        case 27:
            l();
            break
        }
    }).blur(function() {
        if (x.is(":visible") && D > 0) {
        	
        } else {
            l()
        }
    });
    /**
     * 支持方向键上下移动
     */
    function o(I) {
        var H = jQuery("li", x);
        if (!H || H.length == 0) {
            return false
        }
        i += I;
        if (i < 0) {
            i = H.size()
        } else {
            if (i > H.size()) {
                i = 0
            }
        }
        H.removeClass(c.hoverClass);
        jQuery(H[i]).addClass(c.hoverClass)
    }
    /**
     * 增加样式
     */
     function B() {
        var H = jQuery("<div></div>");
        H.addClass("mainCon");
        return H
    }
    /**
     * 隐藏层
     */
    function l() {
        D = 0;
        x.hide()
    }
    /**
     * 隐藏原有对象
     */
    function y() {
        x.append(r(d.attr("id"))).hide();
    }
    /**
     * 创建下拉列层.加入样式与ID
     */
    function k(H) {
        var I = jQuery("<div></div>");
        I.attr("id", elm_id + "_container");
        I.addClass(H.containerClass);
        return I
    }
    /**
     * 创建下拉列文本区域
     */
    function q(I) {
    	//创建input对象
        var H = document.createElement("input");
        //赋值
        var K = jQuery(H);
        //基本属性 id 文本类型 Css样式
        K.attr("id", elm_id + "_input");
        K.attr("type", "text");
        K.addClass(I.inputClass);
        return K
    }
    /**
     * 点击显示列层将对应值存入文本框中
     */
    function h() {
    	//获取li对象第一个属性值
        var H = jQuery("li." + c.currentClass, x).get(0);
        var I = (H.id).split("_");
        var K = I[0].length + I[1].length + 2;
        var L = H.id;
        var J = L.substr(K, L.length);
        //将值塞入对象中
        A.val(J);
        A.attr("relText", jQuery(H).text());
        d.val(jQuery(H).html());
        A.focus();
        return true
    }
    /**
     * 对象value值
     */
    function s() {
        return A.val()
    }
     /**
     * 对象value值
     */
    function m() {
        return d.val()
    }
     /**
     * 创建option 属性层
     */
    function r(N) {
    	var H;
        var K = document.createElement("ul");
        var J = 1;
        if (A.attr("bindingobject") != null) {
            H = true
        }
        A.find("option").each(function() {
            var P = document.createElement("li");
            P.setAttribute("id", N + "_" + jQuery(this).val());
            P.innerHTML = jQuery(this).html();
            //是否为默认选择项
            if (jQuery(this).is(":selected")) {
                d.val(jQuery(this).html());
                jQuery(P).addClass(c.currentClass)
            }
            K.appendChild(P);
            jQuery(P).mouseover(function(S) {
                D = 1;
                jQuery(S.target, x).addClass(c.hoverClass)
            }).mouseout(function(S) {
                D = -1;
                jQuery(S.target, x).removeClass(c.hoverClass)
            }).click(function(T) {
            	//清除上次选择的样式
                var S = jQuery(this).attr("id").split("_");
                jQuery("#" + S[0] + "_container li." + c.currentClass).removeClass(c.currentClass);
                //增加选择样式
                jQuery(this).addClass(c.currentClass);
                //选择列表数据,选中该值.
                h();
              	//选择后隐藏
                l();
                //t方法只有在级联cascade为true时才调用
		        if(A.attr("cascade") != null){
			    	if(A.attr("cascade") == "true"){
			    		if (H) {
				             t(A, A.val());
				        }
			    	}
			    }
            }).blur(function() {
		        if (x.is(":visible") && D > 0) {
		        	
		        } else {
		            l()
		        }
		    })
        });
        return K
    };
    function t(J, I) {
	    if (I != "") {
	    	var K = J.attr("bindingobject");
	    	var H = jQuery("#" + K).prev().find("div[class=loader]");
	    	H.show();
	        window.setTimeout(function() {
	            z(J, I)
	        },
	       	200)
	    }
	};
	function z(J, I) {
	    var H;
	    var V;
	    if (J.attr("childDataPath") != null) {
	        H = J.attr("childDataPath");
	    }
	    if(I != null){
	    	V = I;
	    }
	    //var comment = {};
	    //comment.value = V;
	    jQuery.ajax({
	    	type : 'post',
	        url: H,
	        beforeSend: function(XMLHttpRequest){
	        	//回调函数
	        	var K = J.attr("bindingobject");
	        	var S = jQuery("#" + K).prev().find("div[class=loader]");
				S.hide();
			},
	        dataType: "json",
	       	data : {'value':V},//,jQuery.toJSON(comment)
	        error: function() {
	            try {
	                top.Dialog.alert("数据加载失败，请检查路径是否正确")
	            } catch(K) {
	                alert("数据加载失败，请检查路径是否正确")
	            }
	        },
	        success: function(N) {
	        	//根据返回的json动态产生内容
	        	//var N=data;//eval("("+data+")");//转换为json对象 
	        	//获取绑定对象
	        	var K = J.attr("bindingobject");
	        	//创建基本属性
	            var Q = jQuery("#" + K).prev().find("ul");
	            var M = jQuery("#" + K).prev().find(">div").attr("id").split("_")[0];
	            var L = jQuery("#" + K).prev().find("input:text");
	            var O = jQuery("#" + K)[0];
	            Q.html("");
	            O.options.length = 0;
	            //创建内容页
	         	jQuery(N).each(function() {
	         		//获取显示值和value值
	         		var V = jQuery(this).attr("name");
               	 	var U = jQuery(this).attr("value");
               	 	//创建LI
               	  	var T = document.createElement("li");
               	  	//动态创建内容
                    jQuery(T).text(V);
                    jQuery(T).attr("relValue", U);
                    //显示层值
                    Q.append(jQuery(T));
                    O.options[O.options.length] = new Option(V, U);
                    //获取 与 失去焦点后样式变化
                    jQuery(T).mouseover(function(W) {
                        jQuery(W.target).addClass(c.hoverClass)
                    });
                    jQuery(T).mouseout(function(W) {
                        jQuery(W.target).removeClass(c.hoverClass)
                    });
                    //当按下鼠标按钮时，隐藏或显示元素
                    jQuery(T).mousedown(function(X) {
                        jQuery("#" + M + "_container li." + c.currentClass).removeClass(c.currentClass);
                        jQuery(this).addClass(c.currentClass);
                        jQuery("#" + K).attr("relText", jQuery(this).text());
                        jQuery("#" + K).val(jQuery(this).attr("relValue"));
                        L.val(jQuery(this).html());
                        jQuery("#" + K).prev().find(">div").hide();
                        jQuery("#" + K).focus();
                        if (jQuery("#" + K).attr("onchange") != null) {
                            jQuery(jQuery("#" + K).attr("onchange"))
                        }
                        var W;
                        if (jQuery("#" + K).attr("childId") != null) {
                            W = true
                        }
                        if (W) {
                            t(jQuery("#" + K), jQuery("#" + K).val())
                        }
                    });
	     		});
	     		//查无数据显示
                if (jQuery(N).length == 0) {
                    var R = document.createElement("li");
                    jQuery(R).text("查无内容");
                   	Q.append(jQuery(R))
                }
                //默认选择第一个
                var P = Q.find("li").eq(0);
                L.val(P.text());
                P.addClass(c.currentClass);
                jQuery("#" + K).attr("relValue", P.attr("relValue"));
                jQuery("#" + K).attr("relText", P.text())
	        }
	    })
	}
};