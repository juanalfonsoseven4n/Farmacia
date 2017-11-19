YAHOO.namespace("example.container");
				
				// BEGIN RESIZEPANEL SUBCLASS //
				YAHOO.widget.ResizePanel = function(el, userConfig) {
					if (arguments.length > 0) {
						YAHOO.widget.ResizePanel.superclass.constructor.call(this, el, userConfig);
					}
				}

				YAHOO.extend(YAHOO.widget.ResizePanel, YAHOO.widget.Panel);

				YAHOO.widget.ResizePanel.CSS_PANEL_RESIZE = "resizepanel";

				YAHOO.widget.ResizePanel.CSS_RESIZE_HANDLE = "resizehandle";

				YAHOO.widget.ResizePanel.prototype.init = function(el, userConfig) {
					YAHOO.widget.ResizePanel.superclass.init.call(this, el);
					this.beforeInitEvent.fire(YAHOO.widget.ResizePanel);

					YAHOO.util.Dom.addClass(this.innerElement, YAHOO.widget.ResizePanel.CSS_PANEL_RESIZE);

					this.resizeHandle = document.createElement("DIV");
					this.resizeHandle.id = this.id + "_r";
					this.resizeHandle.className = YAHOO.widget.ResizePanel.CSS_RESIZE_HANDLE;
						
                    this.beforeShowEvent.subscribe(function() {

                        this.body.style.overflow = "auto";
                    
                    }, this, true);


                    this.beforeHideEvent.subscribe(function() {

                        /*
                             Set the CSS "overflow" property to "hidden" before
                             hiding the panel to prevent the scrollbars from 
                             bleeding through on Firefox for OS X.
                        */

                        this.body.style.overflow = "hidden";
                    
                    }, this, true);


					this.beforeRenderEvent.subscribe(function() {

                        /*
                             Set the CSS "overflow" property to "hidden" by
                             default to prevent the scrollbars from bleeding
                             through on Firefox for OS X.
                        */

                        this.body.style.overflow = "hidden";

                        if (! this.footer) {
                            this.setFooter("");
                        }

                    }, this, true);

					this.renderEvent.subscribe(function() {
						var me = this;
						
						me.innerElement.appendChild(me.resizeHandle);

						this.ddResize = new YAHOO.util.DragDrop(this.resizeHandle.id, this.id);
						this.ddResize.setHandleElId(this.resizeHandle.id);

						var headerHeight = me.header.offsetHeight;

						this.ddResize.onMouseDown = function(e) {

							this.startWidth = me.innerElement.offsetWidth;
							this.startHeight = me.innerElement.offsetHeight;
							
							me.cfg.setProperty("width", this.startWidth + "px");
							me.cfg.setProperty("height", this.startHeight + "px");

							this.startPos = [YAHOO.util.Event.getPageX(e),
											 YAHOO.util.Event.getPageY(e)];

							me.innerElement.style.overflow = "hidden";
							me.body.style.overflow = "auto";
						}
						
						this.ddResize.onDrag = function(e) {
							var newPos = [YAHOO.util.Event.getPageX(e),
										  YAHOO.util.Event.getPageY(e)];
							
							var offsetX = newPos[0] - this.startPos[0];
							var offsetY = newPos[1] - this.startPos[1];
					
							var newWidth = Math.max(this.startWidth + offsetX, 10);
							var newHeight = Math.max(this.startHeight + offsetY, 10);

							me.cfg.setProperty("width", newWidth + "px");
							me.cfg.setProperty("height", newHeight + "px");

							var bodyHeight = (newHeight - 5 - me.footer.offsetHeight - me.header.offsetHeight - 3);
							if (bodyHeight < 0) {
								bodyHeight = 0;
							}

							me.body.style.height =  bodyHeight + "px";

							var innerHeight = me.innerElement.offsetHeight;
							var innerWidth = me.innerElement.offsetWidth;

							if (innerHeight < headerHeight) {
								me.innerElement.style.height = headerHeight + "px";
							}

							if (innerWidth < 20) {
								me.innerElement.style.width = "20px";
							}
						}

					}, this, true);

					if (userConfig) {
						this.cfg.applyConfig(userConfig, true);
					}

					this.initEvent.fire(YAHOO.widget.ResizePanel);
				};

				YAHOO.widget.ResizePanel.prototype.toString = function() {
					return "ResizePanel " + this.id;
				};
				
				// END RESIZEPANEL SUBCLASS //

				function init() {
					YAHOO.example.container.panel1 = new YAHOO.widget.ResizePanel("panel1", { visible:false, constraintoviewport:true, effect:{effect:YAHOO.widget.ContainerEffect.FADE,duration:0.25}, height:"420px",  width:"500px" } );
					
					YAHOO.example.container.panel1.render();
					
										
					YAHOO.util.Event.addListener("show1", "click", YAHOO.example.container.panel1.show, YAHOO.example.container.panel1, true);
					YAHOO.util.Event.addListener("hide1", "click", YAHOO.example.container.panel1.hide, YAHOO.example.container.panel1, true);
					
					
					
					
				
					YAHOO.example.container.panel2 = new YAHOO.widget.Panel("panel2", { xy:[355,170],
																							 height:"420px",
																			 		effect:{effect:YAHOO.widget.ContainerEffect.FADE,duration:0.25},
																							  width:"500px"} );
					YAHOO.example.container.panel2.render();
					
					YAHOO.example.container.manager = new YAHOO.widget.OverlayManager();
					YAHOO.example.container.manager.register([YAHOO.example.container.panel1,
															  YAHOO.example.container.panel2,
															  ]);

									
				
				}

				YAHOO.util.Event.addListener(window, "load", init);
